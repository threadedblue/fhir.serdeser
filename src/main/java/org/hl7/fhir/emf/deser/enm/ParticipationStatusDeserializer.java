package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ParticipationStatus;
import org.hl7.fhir.ParticipationStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ParticipationStatusDeserializer extends JsonDeserializer<ParticipationStatus> {

public ParticipationStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ParticipationStatus enm = FhirFactory.eINSTANCE.createParticipationStatus();
	String s = p.getValueAsString();
	enm.setValue(ParticipationStatusEnum.getByName(s));
	return enm;
	}
}
