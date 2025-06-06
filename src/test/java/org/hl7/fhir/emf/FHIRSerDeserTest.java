package org.hl7.fhir.emf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.hl7.fhir.Address;
import org.hl7.fhir.Bundle;
import org.hl7.fhir.BundleEntry;
import org.hl7.fhir.BundleType;
import org.hl7.fhir.BundleTypeEnum;
import org.hl7.fhir.ClaimResponse;
import org.hl7.fhir.Code;
import org.hl7.fhir.CodeableConcept;
import org.hl7.fhir.Coding;
import org.hl7.fhir.ContactPoint;
import org.hl7.fhir.ContactPointSystem;
import org.hl7.fhir.ContactPointSystemEnum;
import org.hl7.fhir.ExplanationOfBenefit;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.HumanName;
import org.hl7.fhir.Organization;
import org.hl7.fhir.Patient;
import org.hl7.fhir.Practitioner;
import org.hl7.fhir.ResourceContainer;
import org.hl7.fhir.Uri;
import org.hl7.fhir.ValueSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FHIRSerDeserTest {

	private static final Logger log = LoggerFactory.getLogger(FHIRSerDeserTest.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testLoad() {
		InputStream reader = FHIRSerDeserTest.class.getClassLoader().getResourceAsStream("AliciaPatez.json");
		try {
			EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
			assertNotNull(eObject);
			log.info("eObject=={}", eObject.eClass().getName());
			Patient patient = (Patient) eObject;
			OutputStream writer = FHIRSerDeser.save(patient, Finals.SDS_FORMAT.XML);
			log.debug("Patient as XML=={}", writer.toString());
			log.info("patient.id=={}", patient.getId().getValue());
			EList<HumanName> name = patient.getName();
			assertNotNull(name);
//			assertEquals(name.size(), 1);
			log.info("patient.name.size=={}", name.size());
			// log.info("patient.name.family=={}", name.get(0).getFamily());
			// log.info("patient.name.given=={}", name.get(0).getGiven());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
	void testLoadJSONBundle() {
		InputStream reader = null;
		reader = FHIRSerDeserTest.class.getClassLoader().getResourceAsStream("Alicia.json");

		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		ValueSet sut = (ValueSet) eObject;
		assertNotNull(sut);
		log.info("ValueSet=" + sut.eClass().getName());
	}

//	@Test
	void testLoadJSONSynteaBundleSet() {
		InputStream reader = null;
		File syntheaDir = new File("/Users/gcr/eccWk/FHIRSDSData/examples-json");
		int fileCount = 0;
		for (File syntheaFile : syntheaDir.listFiles()) {
			log.info("Processing " + (++fileCount) + "==>" + syntheaFile.getName());
			try {
				reader = new FileInputStream(syntheaFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
			assertNotNull(eObject);
			ValueSet sut = (ValueSet) eObject;
			assertNotNull(sut);
			log.info("ValueSet=" + sut.eClass().getName());
		}
	}

//	@Test
	void testLoadJSONAddr1() {
		InputStream reader = null;
		reader = FHIRSerDeserTest.class.getClassLoader().getResourceAsStream("Alicia.json");
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		Address sut = (Address) eObject;
		assertNotNull(sut);
		log.info("Addr1=" + sut.eClass().getName());
	}

//	@Test
	void testLoadJSONAddr2() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/address-2.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertNotNull(reader);
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		// Address sut = (Address) eObject;
		// assertNotNull(sut);
		// log.info("Addr2=" + sut.eClass().getName());
	}
	
//	@Test
	void testLoadJSONClaimResponse() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("/Users/gcr/eccWk/FHIRSDSData/examples-json/claimresponse-example-unsolicited-preauth.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		ClaimResponse sut = (ClaimResponse) eObject;
		assertNotNull(sut);
		log.info("ClaimResponse=" + sut.eClass().getName());
	}
	
//	@Test
	void testLoadJSONEoB() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/explanationofbenefit.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		ExplanationOfBenefit sut = (ExplanationOfBenefit) eObject;
		assertNotNull(sut);
		log.info("ExplanationOfBenefit=" + sut.eClass().getName());
	}

	@Test
	void testLoadJSONOrg1() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/organization-1.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		Organization sut = (Organization) eObject;
		log.info("Organization-1=" + sut.eClass().getName());
		assertNotNull(sut);
		assertNotNull(sut.getTelecom());
		assertNotNull(sut.getTelecom().get(0));
		assertEquals(1, sut.getTelecom().size());
		assertNotNull(sut.getTelecom().get(0).getSystem());
		assertEquals("phone", sut.getTelecom().get(0).getSystem().getValue().getLiteral());
		assertNotNull(sut.getTelecom().get(0).getUse());
		assertEquals("work", sut.getTelecom().get(0).getUse().getValue().getLiteral());
		assertNotNull(sut.getTelecom().get(0).getValue());
		assertEquals("9786323420", sut.getTelecom().get(0).getValue().getValue());
	}

	@Test
	void testLoadJSONOrg3() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/organization-3.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		Organization sut = (Organization) eObject;
		log.info("Organization-3=" + sut.eClass().getName());
		assertNotNull(sut);
		assertNotNull(sut.getTelecom());
		assertNotNull(sut.getTelecom().get(0));
		assertEquals(1, sut.getTelecom().size());
		assertNotNull(sut.getTelecom().get(0).getSystem());
		assertEquals("phone", sut.getTelecom().get(0).getSystem().getValue().getLiteral());
		assertNotNull(sut.getTelecom().get(0).getUse());
		assertEquals("home", sut.getTelecom().get(0).getUse().getValue().getLiteral());
		assertNotNull(sut.getTelecom().get(0).getValue());
		assertEquals("9786323420", sut.getTelecom().get(0).getValue().getValue());
	}

//	@Test
	void testLoadJSONContactPoint() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/telecom.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		ContactPoint sut = (ContactPoint) eObject;
		log.info("ContactPoint=", sut.eClass().getName());
		assertNotNull(sut);
	}

	@Test
	void testLoadJSONPat1() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/Alicia-1.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		Patient sut = (Patient) eObject;
		log.info("Patient-1=" + sut.eClass().getName());
		assertNotNull(sut);
	}

	@Test
	void testLoadJSONPat2() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/Alicia-2.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
		assertNotNull(eObject);
		Patient sut = (Patient) eObject;
		assertNotNull(sut);
	}

	@Test
	void testAssembleURI() {
		URI uri = FHIRSerDeser.assembleURI(Finals.SDS_FORMAT.XML);
		assertNotNull(uri);
		assertEquals(Finals.SCHEME, uri.scheme());
		assertEquals(Finals.SDS_FORMAT.XML.toString(), uri.fileExtension());
	}

////	@Test
//	void testLoadXMLDR() {
//		URL sutURL = getClass().getClassLoader().getResource("diagnostic-report-genomics.xml");
//		InputStream reader = null;
//		try {
//			reader = sutURL.openStream();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		EObject eObject = FHIRSerDeser.load(sutURL);
//		assertNotNull(eObject);
//		Bundle sut = (Bundle) eObject;
//		assertNotNull(sut);
//	}

//	 @Test
//	void testSave() {
//		URL patientURL = getClass().getClassLoader().getResource("patient.xml");
//		EObject eObject = FHIRSerDeser.load(patientURL, Finals.SDS_FORMAT.JSON);
//		assertNotNull(eObject);
//		OutputStream out = null;
//		out = FHIRSerDeser.save(eObject, Finals.SDS_FORMAT.JSON);
//		assertNotNull(out);
//	}

	@Test
	void testSaveBundle() {
		Bundle sut = createBundle();
		OutputStream os = FHIRSerDeser.save(sut, Finals.SDS_FORMAT.JSON);
		assertNotNull(os);
	}

	@Test
	void testSaveOrgAsXML() {
		Organization org = createOrganization();
		OutputStream os = FHIRSerDeser.save(org, Finals.SDS_FORMAT.JSON);
		assertNotNull(os);
	}

	@Test
	void testSaveOrgAsJSON() {
		Organization org = createOrganization();
		OutputStream os = FHIRSerDeser.save(org, Finals.SDS_FORMAT.JSON);
		assertNotNull(os);
	}

	Bundle createBundle() {
		Bundle sut = FhirFactory.eINSTANCE.createBundle();
		BundleType sutType = FhirFactory.eINSTANCE.createBundleType();
		sutType.setValue(BundleTypeEnum.TRANSACTION);
		sut.setType(sutType);
		BundleEntry sutEntry1 = FhirFactory.eINSTANCE.createBundleEntry();
		sut.getEntry().add(sutEntry1);
		ResourceContainer resourceContainer1 = FhirFactory.eINSTANCE.createResourceContainer();
		sutEntry1.setResource(resourceContainer1);
		Patient patient = FhirFactory.eINSTANCE.createPatient();
		resourceContainer1.setPatient(patient);
		org.hl7.fhir.String id1 = FhirFactory.eINSTANCE.createString();
		id1.setValue("org-id-111");
//		id1.setId("111");
		Uri uri1 = FhirFactory.eINSTANCE.createUri();
		uri1.setId("111");
		uri1.setValue("urn:uuid:0c0652be-de47-46c3-9f40-54aaf0c30d8f");
		sutEntry1.setFullUrl(uri1);
		sutEntry1.setId("111");
		patient.setId(id1);

		BundleEntry sutEntry2 = FhirFactory.eINSTANCE.createBundleEntry();
		sut.getEntry().add(sutEntry2);
		ResourceContainer resourceContainer2 = FhirFactory.eINSTANCE.createResourceContainer();
		sutEntry2.setResource(resourceContainer2);
		Practitioner practitioner = FhirFactory.eINSTANCE.createPractitioner();
		resourceContainer2.setPractitioner(practitioner);
		org.hl7.fhir.String id2 = FhirFactory.eINSTANCE.createString();
		id2.setId("222");
		Uri uri2 = FhirFactory.eINSTANCE.createUri();
		uri2.setValue("urn:bbb");
		sutEntry2.setFullUrl(uri2);
		sutEntry2.setId("222");
		practitioner.setId(id2);

//		BundleEntry sutEntry3 = FhirFactory.eINSTANCE.createBundleEntry();
//		sut.getEntry().add(sutEntry3);
//		ResourceContainer resourceContainer3 = FhirFactory.eINSTANCE.createResourceContainer();
//		sutEntry3.setResource(resourceContainer3);
//		Organization organization = FhirFactory.eINSTANCE.createOrganization();
//		resourceContainer3.setOrganization(organization);
//		Id id3 = FhirFactory.eINSTANCE.createId();
//		id3.setId("333");
//		Uri uri3 = FhirFactory.eINSTANCE.createUri();
//		uri3.setValue("urn:ccc");
//		sutEntry3.setFullUrl(uri3);
//		sutEntry3.setId("333");
//		organization.setId(id3);
//		
		return sut;
	}

	public Organization createOrganization() {
		Organization org = FhirFactory.eINSTANCE.createOrganization();
		org.hl7.fhir.String id = FhirFactory.eINSTANCE.createString();
		id.setValue("org-id-111");
		org.setId(id);
		CodeableConcept cc = FhirFactory.eINSTANCE.createCodeableConcept();
		Coding coding = FhirFactory.eINSTANCE.createCoding();

		Code code = FhirFactory.eINSTANCE.createCode();
		code.setValue("code value");
		coding.setCode(code);

		org.hl7.fhir.String display = FhirFactory.eINSTANCE.createString();
		display.setValue("coding display");
		coding.setDisplay(display);

		Uri system = FhirFactory.eINSTANCE.createUri();
		system.setValue("uri value");
		coding.setSystem(system);

		cc.getCoding().add(coding);

		ContactPoint telecom = FhirFactory.eINSTANCE.createContactPoint();
		ContactPointSystem system1 = FhirFactory.eINSTANCE.createContactPointSystem();
		system1.setValue(ContactPointSystemEnum.PHONE);
		telecom.setSystem(system1);
		org.hl7.fhir.String telecomValue = FhirFactory.eINSTANCE.createString();
		telecomValue.setValue("5086745600");
		telecom.setValue(telecomValue);

		org.getType().add(cc);
		org.getTelecom().add(telecom);
		return org;
	}
}
