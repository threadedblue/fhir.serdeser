package org.hl7.fhir.emf;

import java.util.Arrays;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class FHIR2AA {

	static final Logger log = LoggerFactory.getLogger(FHIR2AA.class);

	public static final int COL = 0, VAL = 1, LEN = 2;

	EObject eObject;
	String id;
	Table<String, String, String> rcvs = TreeBasedTable.create();
	static Stack<String> path = new Stack<>();
	SDSSwitch sdsSwitch = new SDSSwitch();
	SkipSwitch skipSwitch = new SkipSwitch();

	// TODO constructor is useless.  Eliminate and make toFHIRAA a static call.
	public FHIR2AA(EObject eObject) {
		super();
		this.eObject = eObject;
		this.id = ((org.hl7.fhir.Resource) eObject).getId().getValue();
	}

	public static Table<String, String, String> toFHIRAA(EObject eObject) {
		try {
			FHIR2AA fhir2aa = new FHIR2AA(eObject);
			EClass eClass = eObject.eClass();
			path.push(eClass.getName());
			log.trace("pushed=" + Arrays.asList(path.toArray()));
			return fhir2aa.serialize(eObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Table<String, String, String> serialize(final EObject eObject) {
		EClass eClass = eObject.eClass();
		if (skipSwitch.doSwitch(eObject)) {
			return rcvs;
		}
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		if (eClass == eAnnotation.eClass()) {
			return rcvs;
		}

		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			log.trace("eAttribute=" + eClass.getName() + "." + eAttribute.getName());
			serialize(eObject, eAttribute);
		}

		for (EReference eReference : eClass.getEAllReferences()) {
			log.trace("eReference=" + eClass.getName() + "." + eReference.getName());
			serialize(eObject, eReference);
		}
		return rcvs;
	}

	public void serialize(final EObject eObject, final EAttribute eAttribute) {

		if (isOr(eObject, eAttribute)) {
			return;
		}
		if (skipSwitch.doSwitch(eObject)) {
			return;
		}

		if (eAttribute.isMany()) {
			log.info("isMany=" + eAttribute.getName());
			for (EObject eObject1 : eAttribute.eContents()) {
				serializeOne(eObject1, eAttribute);
			}
		} else {
			serializeOne(eObject, eAttribute);
		}
		return;
	}

	public void serializeOne(final EObject eObject, final EAttribute eAttribute) {
		if (eObject.eIsSet(eAttribute)) {
			path.push(eAttribute.getName());
			log.trace("pushed=" + Arrays.asList(path.toArray()));
			String[] cv = new String[LEN];
			cv[COL] = assemblePath(eAttribute);
			cv[VAL] = sdsSwitch.doSwitch(eObject);
			addRCV(cv);
			path.pop();
			log.trace("popped=" + Arrays.asList(path.toArray()));
		}
		return;
	}

	public void serialize(final EObject eObject, final EReference eReference) {
		if (isOr(eObject, eReference)) {
			return;
		}

		String _name = eReference.getName();
		Object value = eObject.eGet(eReference);
		if (eReference.isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> contents = (EList<EObject>) eObject.eGet(eReference);

			for (EObject eObject1 : contents) {
				if (skipSwitch.doSwitch(eObject1)) {
					return;
				}

				serializeOne(eObject1, eReference, (EObject) eObject1);
			}
		} else {
			if (skipSwitch.doSwitch((EObject) value)) {
				return;
			}

			serializeOne(eObject, eReference, (EObject) value);
		}
		return;
	}

	public void serializeOne(final EObject eObject, final EReference eReference, EObject value) {
		if (skipSwitch.doSwitch(value)) {
			return;
		}
		log.trace("eReference serialize=" + eReference.getName());
		if (eReference.isContainment()) {
			log.trace("was containment");
			path.push(eReference.getName());
			log.trace("pushed=" + Arrays.asList(path.toArray()));
			serialize(value);
			path.pop();
			log.trace("poped=" + Arrays.asList(path.toArray()));
		} else {
			log.trace("!was containment");
			path.push(eReference.getName());
			log.trace("pushed=" + Arrays.asList(path.toArray()));
			String[] cv = new String[LEN];
			cv[COL] = assemblePath(eReference);
			cv[VAL] = sdsSwitch.doSwitch(value);
			addRCV(cv);
			path.pop();
			log.trace("popped=" + Arrays.asList(path.toArray()));
		}
		return;
	}

	public String assemblePath(ENamedElement eNE) {
		return String.join(".", path.toArray(new String[path.size()]));
	}

	public void collectColumns(ENamedElement eNE) {
		String eNEName = checkInstanceType(eNE);
		if (!"fhir".equals(eNEName)) {
			ENamedElement eNE1 = (ENamedElement) eNE.eContainer();
			collectColumns(eNE1);
		}
	}

	public String checkInstanceType(ENamedElement eNE) {
		String eNEName = eNE.getName();
		if ("Resource".equals(eNEName)) {
			eNEName = this.eObject.eClass().getName();
		}
		return eNEName;
	}

	public boolean addRCV(String[] cv) {
		if (cvNotNull(cv)) {
			rcvs.put(id, cv[COL], cv[VAL]);
			log.trace("Added=" + Arrays.asList(cv));
			return true;
		} else {
			return false;
		}
	}

	public boolean cvNotNull(String[] cv) {
		log.trace("cvNotNull=" + Arrays.asList(cv));
		return (cv != null && cv[COL] != null && cv[VAL] != null);
	}

	public boolean isOr(final EObject eObject, final EAttribute eAttribute) {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _isDerived = eAttribute.isDerived();
		if (_isDerived) {
			_or_1 = true;
		} else {
			boolean _isTransient = eAttribute.isTransient();
			_or_1 = _isTransient;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _eIsSet = eObject.eIsSet(eAttribute);
			boolean _not = (!_eIsSet);
			_or = _not;
		}

		return _or;
	}

	public boolean isOr(final EObject eObject, final EReference eReference) {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _isDerived = eReference.isDerived();
		if (_isDerived) {
			_or_1 = true;
		} else {
			boolean _isTransient = eReference.isTransient();
			_or_1 = _isTransient;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _eIsSet = eObject.eIsSet(eReference);
			boolean _not = (!_eIsSet);
			_or = _not;
		}

		return _or;
	}
}
