package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EpisodeOfCareStatus;
import org.hl7.fhir.EpisodeOfCareStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EpisodeOfCareStatusDeserializer extends JsonDeserializer<EpisodeOfCareStatus> {

public EpisodeOfCareStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EpisodeOfCareStatus enm = FhirFactory.eINSTANCE.createEpisodeOfCareStatus();
	String s = p.getValueAsString();
	enm.setValue(EpisodeOfCareStatusEnum.getByName(s));
	return enm;
	}
}
