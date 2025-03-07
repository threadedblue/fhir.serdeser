package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.FhirPackage;
import org.hl7.fhir.emf.FHIRDeserializationSwitch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EMFDeserializer extends JsonDeserializer<EObject> {

	private static final Logger log = LoggerFactory.getLogger(EMFDeserializer.class);

    @Override
    public EObject deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
        	
    		if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
    			p.nextToken();
    		}
    		
            // 🔹 Retrieve ObjectMapper
            ObjectMapper objectMapper = (ObjectMapper) p.getCodec();
            ObjectNode jsonNode = objectMapper.readTree(p);

            // 🔹 Extract "resourceType" from JSON
            String resourceType = jsonNode.get("resourceType").asText();
            if (resourceType == null) {
                throw new IOException("Missing 'resourceType' in JSON!");
            }

            // 🔹 Resolve EClass dynamically from the EMF package
            EClass eClass = getEClassFromName(resourceType);
            log.debug("resourceType=" + resourceType);
            if (eClass == null) {
                throw new IOException("Unknown FHIR resource type: " + resourceType);
            }

            // 🔹 Create an instance using FhirFactory
            EObject instance = FhirFactory.eINSTANCE.create(eClass);
            return instance;
        } catch (Exception e) {
            throw new IOException("Failed to deserialize EMF object", e);
        }
    }

    /**
     * Convert JSON "resourceType" to EClass using FhirPackage.
     */
    private EClass getEClassFromName(String resourceType) {
        EPackage ePackage = FhirPackage.eINSTANCE; // Ensure correct EMF package
        for (EClassifier classifier : ePackage.getEClassifiers()) {
            if (classifier instanceof EClass && classifier.getName().equalsIgnoreCase(resourceType)) {
                return (EClass) classifier;
            }
        }
        return null; // Not found
    }
}
