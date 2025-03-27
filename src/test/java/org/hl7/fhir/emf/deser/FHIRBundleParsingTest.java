package org.hl7.fhir.emf.deser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.hl7.fhir.Bundle;
import org.hl7.fhir.BundleEntry;
import org.hl7.fhir.Claim;
import org.hl7.fhir.Encounter;
import org.hl7.fhir.MedicationRequest;
import org.hl7.fhir.Observation;
import org.hl7.fhir.Organization;
import org.hl7.fhir.Patient;
import org.hl7.fhir.Practitioner;
import org.hl7.fhir.ResourceContainer;
import org.hl7.fhir.emf.FHIRSerDeser;
import org.hl7.fhir.emf.Finals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FHIRBundleParsingTest {

    private static final Logger log = LoggerFactory.getLogger(FHIRBundleParsingTest.class);
    private static EObject parsedBundle;

    @BeforeAll
    static void setup() {
        log.info("Setting up FHIR parsing test...");
        InputStream reader = FHIRBundleParsingTest.class.getClassLoader().getResourceAsStream("Alicia.json");
        assertNotNull(reader, "FHIR JSON file not found!");

        try {
            parsedBundle = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
            assertNotNull(parsedBundle, "Parsed Bundle should not be null");
            assertTrue(parsedBundle instanceof Bundle, "Parsed EObject should be a FHIR Bundle");
        } catch (Exception e) {
            fail("Exception occurred while parsing the FHIR Bundle: " + e.getMessage());
        }
    }

    @Test
    void testBundleStructure() {
        log.info("Testing Bundle structure...");
        Bundle bundle = (Bundle) parsedBundle;

        assertNotNull(bundle.getType(), "Bundle type should not be null");
        assertEquals("transaction", bundle.getType().getValue().getLiteral(), "Bundle type should be 'transaction'");
        assertFalse(bundle.getEntry().isEmpty(), "Bundle should contain entries");
    }

    @Test
    void testPatientParsingParticular() {
        log.info("Testing Patient resource...");
        Bundle bundle = (Bundle) parsedBundle;

        boolean foundPatient = false;
        BundleEntry entry = bundle.getEntry().get(0);
        EObject eObject = entry.getResource();
        ResourceContainer resourceContainer = null;
        if (eObject instanceof ResourceContainer) {
            resourceContainer = (ResourceContainer)eObject;
        for (EReference eReference : resourceContainer.eClass().getEAllReferences()) {
            Object value = resourceContainer.eGet(eReference);
            log.info("value=" + eReference.getName() + " " + value);
	        if (value instanceof Patient) {
                foundPatient = true;
                Patient patient = (Patient) value;
                assertNotNull(patient.getId(), "Patient ID should not be null");
                assertNotNull(patient.getName(), "Patient should have a name");
                assertFalse(patient.getName().isEmpty(), "Patient name should not be empty");
                log.info("Patient found with ID: " + patient.getId().getValue());
            }
        }
    } else {
        log.error("entry is not instance of ResourceContainer.");
    }

        assertTrue(foundPatient, "Bundle should contain a Patient resource");
    }

    @Test
    void testPatientParsing() {
        log.info("Testing Patient resource...");
        Bundle bundle = (Bundle) parsedBundle;

        boolean foundPatient = false;
        for (var entry : bundle.getEntry()) {
            EObject resource = entry.getResource();
            if (resource instanceof Patient) {
                foundPatient = true;
                Patient patient = (Patient) resource;
                assertNotNull(patient.getId(), "Patient ID should not be null");
                assertNotNull(patient.getName(), "Patient should have a name");
                assertFalse(patient.getName().isEmpty(), "Patient name should not be empty");
                log.info("Patient found with ID: " + patient.getId().getValue());
            }
        }
        assertTrue(foundPatient, "Bundle should contain a Patient resource");
    }

    @Test
    void testObservationParsing() {
        log.info("Testing Observation resources...");
        Bundle bundle = (Bundle) parsedBundle;

        boolean foundObservation = false;
        for (var entry : bundle.getEntry()) {
            EObject resource = entry.getResource();
            if (resource instanceof Observation) {
                foundObservation = true;
                Observation obs = (Observation) resource;
                assertNotNull(obs.getId(), "Observation ID should not be null");
                assertNotNull(obs.getStatus(), "Observation should have a status");
                assertNotNull(obs.getEffectiveDateTime(), "Observation should have an effectiveDateTime");
                log.info("Observation found with ID: " + obs.getId().getValue());
            }
        }
        assertTrue(foundObservation, "Bundle should contain an Observation resource");
    }

    @Test
    void testPractitionerParsing() {
        log.info("Testing Practitioner resource...");
        Bundle bundle = (Bundle) parsedBundle;

        boolean foundPractitioner = false;
        for (var entry : bundle.getEntry()) {
            EObject resource = entry.getResource();
            if (resource instanceof Practitioner) {
                foundPractitioner = true;
                Practitioner practitioner = (Practitioner) resource;
                assertNotNull(practitioner.getId(), "Practitioner ID should not be null");
                assertNotNull(practitioner.getName(), "Practitioner should have a name");
                log.info("Practitioner found with ID: " + practitioner.getId().getValue());
            }
        }
        assertTrue(foundPractitioner, "Bundle should contain a Practitioner resource");
    }

    @Test
    void testEncounterParsing() {
        log.info("Testing Encounter resource...");
        Bundle bundle = (Bundle) parsedBundle;

        boolean foundEncounter = false;
        for (var entry : bundle.getEntry()) {
            EObject resource = entry.getResource();
            if (resource instanceof Encounter) {
                foundEncounter = true;
                Encounter encounter = (Encounter) resource;
                assertNotNull(encounter.getId(), "Encounter ID should not be null");
                assertNotNull(encounter.getStatus(), "Encounter should have a status");
                log.info("Encounter found with ID: " + encounter.getId().getValue());
            }
        }
        assertTrue(foundEncounter, "Bundle should contain an Encounter resource");
    }

    @Test
    void testClaimParsing() {
        log.info("Testing Claim resource...");
        Bundle bundle = (Bundle) parsedBundle;

        boolean foundClaim = false;
        for (var entry : bundle.getEntry()) {
            EObject resource = entry.getResource();
            log.info("resource=" + resource.eClass().getName());
            if (resource instanceof Claim) {
                foundClaim = true;
                Claim claim = (Claim) resource;
                assertNotNull(claim.getId(), "Claim ID should not be null");
                assertNotNull(claim.getStatus(), "Claim should have a status");
                log.info("Claim found with ID: " + claim.getId().getValue());
            }
        }
        assertTrue(foundClaim, "Bundle should contain a Claim resource");
    }

    @Test
    void testMedicationRequestParsing() {
        log.info("Testing MedicationRequest resource...");
        Bundle bundle = (Bundle) parsedBundle;

        boolean foundMedicationRequest = false;
        for (var entry : bundle.getEntry()) {
            EObject resource = entry.getResource();
            if (resource instanceof MedicationRequest) {
                foundMedicationRequest = true;
                MedicationRequest medReq = (MedicationRequest) resource;
                assertNotNull(medReq.getId(), "MedicationRequest ID should not be null");
                assertNotNull(medReq.getStatus(), "MedicationRequest should have a status");
                log.info("MedicationRequest found with ID: " + medReq.getId().getValue());
            }
        }
        assertTrue(foundMedicationRequest, "Bundle should contain a MedicationRequest resource");
    }

    @Test
    void testOrganizationParsing() {
        log.info("Testing Organization resource...");
        Bundle bundle = (Bundle) parsedBundle;

        boolean foundOrganization = false;
        for (var entry : bundle.getEntry()) {
            EObject resource = entry.getResource();
            if (resource instanceof Organization) {
                foundOrganization = true;
                Organization organization = (Organization) resource;
                assertNotNull(organization.getId(), "Organization ID should not be null");
                assertNotNull(organization.getName(), "Organization should have a name");
                log.info("Organization found with ID: " + organization.getId().getValue());
            }
        }
        assertTrue(foundOrganization, "Bundle should contain an Organization resource");
    }
}
