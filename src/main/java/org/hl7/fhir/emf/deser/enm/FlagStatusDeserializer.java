package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.FlagStatus;
import org.hl7.fhir.FlagStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FlagStatusDeserializer extends JsonDeserializer<FlagStatus> {

public FlagStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	FlagStatus enm = FhirFactory.eINSTANCE.createFlagStatus();
	String s = p.getValueAsString();
	enm.setValue(FlagStatusEnum.getByName(s));
	return enm;
	}
}
