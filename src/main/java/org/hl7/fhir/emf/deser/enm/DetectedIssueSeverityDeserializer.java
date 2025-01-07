package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DetectedIssueSeverity;
import org.hl7.fhir.DetectedIssueSeverityEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DetectedIssueSeverityDeserializer extends JsonDeserializer<DetectedIssueSeverity> {

public DetectedIssueSeverity deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DetectedIssueSeverity enm = FhirFactory.eINSTANCE.createDetectedIssueSeverity();
	String s = p.getValueAsString();
	enm.setValue(DetectedIssueSeverityEnum.getByName(s));
	return enm;
	}
}
