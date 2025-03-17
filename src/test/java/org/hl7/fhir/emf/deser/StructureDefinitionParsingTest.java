package org.hl7.fhir.emf.deser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.emf.ecore.EObject;
import org.hl7.fhir.StructureDefinition;
import org.hl7.fhir.emf.FHIRSerDeser;
import org.hl7.fhir.emf.Finals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StructureDefinitionParsingTest {

    private static final Logger log = LoggerFactory.getLogger(StructureDefinitionParsingTest.class);

    private static EObject parsedStructureDefinition;

    @BeforeAll
    static void setup() {
        log.info("Setting up StructureDefinition parsing test...");
        InputStream reader = StructureDefinitionParsingTest.class.getClassLoader()
                .getResourceAsStream("StructureDefinition-de-identified-uds-plus-patient.json");
        
        assertNotNull(reader, "FHIR StructureDefinition JSON file not found!");

        try {
            if (reader.markSupported()) {
                reader.mark(1024 * 1024);  // Mark before reading
            }
            String rawJson = new String(reader.readAllBytes(), StandardCharsets.UTF_8);
            
            log.trace("Raw JSON Content: " + rawJson);
            if (reader.markSupported()) {
                reader.reset();  // Reset to allow re-reading
            } else {
                log.warn("Mark/reset not supported on this InputStream. Consider using BufferedInputStream.");
            }

            // Check if JSON contains null values
            if (rawJson.contains(": null")) {
                log.warn("JSON contains null values!");
            } else {
                log.info("No null values detected in raw JSON.");
            }

            if (rawJson.contains("\"snapshot\"")) {
                log.info("snapshot is present in the raw JSON.");
            } else {
                log.error("snapshot is missing in the raw JSON!");
            }
            reader.reset();
            parsedStructureDefinition = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
            assertNotNull(parsedStructureDefinition, "Parsed StructureDefinition should not be null");
            assertTrue(parsedStructureDefinition instanceof StructureDefinition, 
                       "Parsed EObject should be a FHIR StructureDefinition");
        } catch (Exception e) {
            fail("Exception occurred while parsing the StructureDefinition: " + e.getMessage());
        }
    }

    @Test
    public void testStructureDefinitionFields() {
        log.info("Testing StructureDefinition key fields...");
        StructureDefinition sd = (StructureDefinition) parsedStructureDefinition;

        assertNotNull(sd.getUrl(), "StructureDefinition URL should not be null");
        assertNotNull(sd.getName(), "StructureDefinition Name should not be null");
        assertNotNull(sd.getType(), "StructureDefinition Type should not be null");

        log.info("Parsed StructureDefinition URL: " + sd.getUrl().getValue());
        log.info("Parsed StructureDefinition Name: " + sd.getName().getValue());
        log.info("Parsed StructureDefinition Type: " + sd.getType().getValue());

        assertTrue(sd.getUrl().getValue().contains("de-identified-uds-plus-patient"),
                   "StructureDefinition URL should match expected format");
    }

    @Test
    void testStructureDefinitionElements() {
        log.info("Testing StructureDefinition elements...");
        StructureDefinition sd = (StructureDefinition) parsedStructureDefinition;
        if (sd.getSnapshot() == null) {
            fail("Snapshot is null after parsing! Check JSON structure or parser.");
        }
        assertNotNull(sd.getSnapshot(), "StructureDefinition snapshot should not be null");
        assertFalse(sd.getSnapshot().getElement().isEmpty(), 
                    "StructureDefinition should contain elements in its snapshot");

        log.info("Number of elements in StructureDefinition snapshot: " + sd.getSnapshot().getElement().size());
    }
}
