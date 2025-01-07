package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ConditionalDeleteStatus;
import org.hl7.fhir.ConditionalDeleteStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConditionalDeleteStatusDeserializer extends JsonDeserializer<ConditionalDeleteStatus> {

public ConditionalDeleteStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ConditionalDeleteStatus enm = FhirFactory.eINSTANCE.createConditionalDeleteStatus();
	String s = p.getValueAsString();
	enm.setValue(ConditionalDeleteStatusEnum.getByName(s));
	return enm;
	}
}
