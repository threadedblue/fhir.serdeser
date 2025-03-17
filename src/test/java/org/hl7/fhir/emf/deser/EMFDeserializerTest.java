package org.hl7.fhir.emf.deser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emfcloud.jackson.databind.EMFContext;
import org.eclipse.emfcloud.jackson.module.EMFModule;
import org.hl7.fhir.Bundle;
import org.hl7.fhir.DateTime;
import org.hl7.fhir.Observation;
import org.hl7.fhir.emf.FHIRSerDeser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;

class EMFDeserializerTest {

	private static final Logger log = LoggerFactory.getLogger(EMFDeserializerTest.class);

	static EMFDeserializer app;
	static JsonParser p;
	static ResourceSet resourceSet;
	static Resource resource;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		log.info("setUpBeforeClass...");
		resourceSet = new ResourceSetImpl();
		app = new EMFDeserializer();
		assertNotNull(app);
		InputStream is = EMFDeserializerTest.class.getClassLoader().getResourceAsStream("Alicia.json");
		log.info("is=" + is);
		assertNotNull(is);
		JsonFactory factory = new JsonFactory();
		JsonParser p = factory.createParser(is);
		assertNotNull(p);
	}
	
	@Test
    public void testObservationDeserialization() throws IOException {
		URI uri = URI.createURI("input.json");
		resource = resourceSet.createResource(uri);
		EMFModule module = new EMFModule();
		module.addDeserializer(EObject.class, new EMFDeserializer());
		module.addDeserializer(org.hl7.fhir.DateTime.class, new DateTimeDeserializer());

        // 🔹 Sample JSON with an Observation (FHIR Bundle format)
        String json = "{"
                + "  \"resourceType\": \"Bundle\","
                + "  \"type\": \"collection\","
                + "  \"entry\": ["
                + "    {"
                + "      \"resource\": {"
                + "        \"resourceType\": \"Observation\","
                + "        \"id\": \"obs1\","
                + "        \"status\": \"final\","
                + "        \"effectiveDateTime\": \"2024-03-07T14:30:00Z\""
                + "      }"
                + "    }"
                + "  ]"
                + "}";

        // Deserialize JSON into a Bundle (FHIR EMF Model)
        StringReader reader = new StringReader(json);
        JsonNode jn = FHIRSerDeser.getMapper().readTree(reader);
		EObject bundleObj = (EObject) FHIRSerDeser.getMapper().reader().withAttribute(EMFContext.Attributes.RESOURCE, resource).forType(Bundle.class)
				.readValue(jn);
        assertNotNull(bundleObj, "Bundle should not be null");
        assertTrue(bundleObj instanceof Bundle, "Deserialized object should be an instance of Bundle");

        Bundle bundle = (Bundle) bundleObj;
        assertFalse(bundle.getEntry().isEmpty(), "Bundle should have at least one entry");
 
        EObject resourceContainer = bundle.getEntry().get(0).getResource();
        assertNotNull(resourceContainer, "ResourceContainer should not be null");
        assertTrue(resourceContainer instanceof org.hl7.fhir.ResourceContainer, 
                   "Resource should be an instance of ResourceContainer");

        log.info("Process observation...");
        Observation observation = (Observation) extractFHIRResource(resourceContainer);
        assertNotNull(observation, "Observation should not be null");
        log.debug(observation.getStatus().getValue().getLiteral());
        assertEquals("final", observation.getStatus().getValue().getLiteral(), "Observation status should be 'final'");

        // 🔹 Verify effectiveDateTime is handled correctly
        DateTime effectiveDateTime = observation.getEffectiveDateTime();
        assertNotNull(effectiveDateTime, "effectiveDateTime should not be null");
        assertEquals("2024-03-07T14:30:00Z", effectiveDateTime.getValue().toXMLFormat(), "effectiveDateTime should match expected value");

        System.out.println("✅ EMFDeserializer successfully processed Observation with DateTime.");
    }

	/**
	 * Extracts the actual FHIR resource from a ResourceContainer.
	 * Uses EMF reflection to find the non-null getter method.
	 */
	private EObject extractFHIRResource(EObject resourceContainer) {
        log.trace("resourceContainer=" + resourceContainer);
	    for (EReference eReference : resourceContainer.eClass().getEAllReferences()) {
	        log.trace("trace=" + eReference.getName());
	        Object value = resourceContainer.eGet(eReference);
	        log.trace("value=" + value);
	        if (value instanceof EObject) {
	            return (EObject) value;
	        }
	    }
	    throw new IllegalArgumentException("No FHIR resource found in ResourceContainer");
	}
}
