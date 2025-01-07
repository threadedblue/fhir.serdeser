package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CapabilityStatementKind;
import org.hl7.fhir.CapabilityStatementKindEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CapabilityStatementKindDeserializer extends JsonDeserializer<CapabilityStatementKind> {

public CapabilityStatementKind deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CapabilityStatementKind enm = FhirFactory.eINSTANCE.createCapabilityStatementKind();
	String s = p.getValueAsString();
	enm.setValue(CapabilityStatementKindEnum.getByName(s));
	return enm;
	}
}
