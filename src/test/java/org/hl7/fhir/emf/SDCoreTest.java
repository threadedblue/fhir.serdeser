package org.hl7.fhir.emf;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.hl7.fhir.Date;
import org.hl7.fhir.Element;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.FhirPackage;
import org.hl7.fhir.Patient;
import org.hl7.fhir.StructureDefinition;
import org.hl7.fhir.StructureDefinitionSnapshot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SDCoreTest {

	private static final Logger LOG = LoggerFactory.getLogger(SDCoreTest.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testLoad() {
		File file = new File("data/StructureDefinition-us-core-patient.xml");
		InputStream reader = null;
		try {
			reader = new FileInputStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			EObject eObject = FHIRSDS.load(reader, Finals.SDS_FORMAT.XML);
			assertNotNull(eObject);
			LOG.info("eObject=" + eObject.eClass().getName());
			StructureDefinition sut = (StructureDefinition) eObject;
			assertNotNull(sut);
			LOG.info("StructureDefinition=" + sut.getFhirVersion());
			LOG.info("StructureDefinition=" + sut.getDate());
			StructureDefinitionSnapshot sds = sut.getSnapshot();
			for (Element el : sds.getElement()) {
				LOG.trace(el.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testLoadJSONPat() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/aaron.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSDS.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		Patient sut = (Patient) eObject;
		LOG.info("Patient=" + sut.eClass().getName());
		assertNotNull(sut);
	}
	
	@Test
	void testManglePat() {
		Patient pat1 = FhirFactory.eINSTANCE.createPatient();
		
		EClass eClass2 = EcoreFactory.eINSTANCE.createEClass();
		eClass2.setName("Patient");
		EClass eClass1 = pat1.eClass();
		EReference eReference0 = FhirPackage.eINSTANCE.getPatient_BirthDate();
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setName("birthDate");
		eReference.setEType(eClass2);
		eReference.setUpperBound(1);
		eReference.setContainment(true);
		EList<EStructuralFeature> eStructuralFeatures = eClass2.getEStructuralFeatures();
		eStructuralFeatures.add(eReference);
//   		Patient pat2 = (Patient) EcoreUtil.create(eClass2);
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(eClass1.getEPackage().getName());
		ePackage.setNsPrefix(eClass1.getEPackage().getNsPrefix());
		ePackage.setNsURI(eClass1.getEPackage().getNsURI());
		ePackage.getEClassifiers().add(eClass2);
		Patient pat2 = (Patient) EcoreFactory.eINSTANCE.create(eClass2);
		XMLGregorianCalendar XCal = null;
		try {
			XCal = DatatypeFactory.newInstance().newXMLGregorianCalendar("1972-07-06");
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = FhirFactory.eINSTANCE.createDate();
		date.setValue(XCal);
		pat2.setBirthDate(date);
		LOG.info("pat2=" + pat2.getBirthDate().getValue().toXMLFormat());
	}
}
