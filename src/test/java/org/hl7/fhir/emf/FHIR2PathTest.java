package org.hl7.fhir.emf;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.hl7.fhir.FhirPackage;
import org.hl7.fhir.Patient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3._1999.xhtml.XhtmlPackage;
import org.w3.xml._1998.namespace.NamespacePackage;

class FHIR2PathTest {

	private static final Logger LOG = LoggerFactory.getLogger(FHIR2PathTest.class);

	static ResourceSet resourceSet;
	SkipSwitch skipSwitch = new SkipSwitch();
	EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMLResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(XhtmlPackage.eNS_URI, XhtmlPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(FhirPackage.eNS_URI, FhirPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(NamespacePackage.eNS_URI, NamespacePackage.eINSTANCE);
	}

	@Test
	void testAllAttributes() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/patient.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSDS.load(reader, Finals.SDS_FORMAT.XML);
		assertNotNull(eObject);
		Patient pat = (Patient) eObject;
		EClass eClass = eObject.eClass();
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			LOG.trace("eAttribute=" + eClass.getName() + "." + eAttribute.getName());
		}
	}

	@Test
	void testAllContents() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/patient.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSDS.load(reader, Finals.SDS_FORMAT.XML);
		assertNotNull(eObject);
		Patient pat = (Patient) eObject;
		Iterator itr = pat.eAllContents();
		while (itr.hasNext()) {
			EObject eObject1 = (EObject) itr.next();
			if (eObject1 instanceof ENamedElement) {
				ENamedElement nel = (ENamedElement) eObject1;
				LOG.info(nel.getName());
			} else {
				LOG.info(eObject1.eClass().getName());
			}
		}
	}

	@Test
	void seekTest() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/patient.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSDS.load(reader, Finals.SDS_FORMAT.XML);
		EClass eClass = eObject.eClass();
		EList<EAttribute> eAttributes = eClass.getEAllAttributes();
		EList<EReference> eReferences = eClass.getEAllReferences();
		EList<EReference> eReferences1 = eClass.getEReferences();
		LOG.info("getEAllAttributes==>");
		for (EAttribute ea : eAttributes) {
			LOG.info("ea=" + ea.getName());
		}
		LOG.info("getEAllReferences==>");
		for (EReference ear : eReferences) {
			LOG.info("ear=" + ear.getName());
		}
		LOG.info("getEReferences==>");
		for (EReference er : eReferences1) {
			LOG.info("er=" + er.getName());
		}
		LOG.info(null);
	}
}
