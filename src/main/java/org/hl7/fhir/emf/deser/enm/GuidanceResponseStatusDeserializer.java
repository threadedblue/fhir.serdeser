package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.GuidanceResponseStatus;
import org.hl7.fhir.GuidanceResponseStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class GuidanceResponseStatusDeserializer extends JsonDeserializer<GuidanceResponseStatus> {

public GuidanceResponseStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	GuidanceResponseStatus enm = FhirFactory.eINSTANCE.createGuidanceResponseStatus();
	String s = p.getValueAsString();
	enm.setValue(GuidanceResponseStatusEnum.getByName(s));
	return enm;
	}
}
