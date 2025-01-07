package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.IssueSeverity;
import org.hl7.fhir.IssueSeverityEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IssueSeverityDeserializer extends JsonDeserializer<IssueSeverity> {

public IssueSeverity deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	IssueSeverity enm = FhirFactory.eINSTANCE.createIssueSeverity();
	String s = p.getValueAsString();
	enm.setValue(IssueSeverityEnum.getByName(s));
	return enm;
	}
}
