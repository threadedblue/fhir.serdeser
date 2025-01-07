package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ConstraintSeverity;
import org.hl7.fhir.ConstraintSeverityEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConstraintSeverityDeserializer extends JsonDeserializer<ConstraintSeverity> {

public ConstraintSeverity deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ConstraintSeverity enm = FhirFactory.eINSTANCE.createConstraintSeverity();
	String s = p.getValueAsString();
	enm.setValue(ConstraintSeverityEnum.getByName(s));
	return enm;
	}
}
