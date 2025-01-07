package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CompositionStatus;
import org.hl7.fhir.CompositionStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CompositionStatusDeserializer extends JsonDeserializer<CompositionStatus> {

public CompositionStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CompositionStatus enm = FhirFactory.eINSTANCE.createCompositionStatus();
	String s = p.getValueAsString();
	enm.setValue(CompositionStatusEnum.getByName(s));
	return enm;
	}
}
