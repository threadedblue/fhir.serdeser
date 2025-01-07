package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ConditionalReadStatus;
import org.hl7.fhir.ConditionalReadStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConditionalReadStatusDeserializer extends JsonDeserializer<ConditionalReadStatus> {

public ConditionalReadStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ConditionalReadStatus enm = FhirFactory.eINSTANCE.createConditionalReadStatus();
	String s = p.getValueAsString();
	enm.setValue(ConditionalReadStatusEnum.getByName(s));
	return enm;
	}
}
