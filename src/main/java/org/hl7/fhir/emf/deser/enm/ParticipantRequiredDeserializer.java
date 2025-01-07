package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ParticipantRequired;
import org.hl7.fhir.ParticipantRequiredEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ParticipantRequiredDeserializer extends JsonDeserializer<ParticipantRequired> {

public ParticipantRequired deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ParticipantRequired enm = FhirFactory.eINSTANCE.createParticipantRequired();
	String s = p.getValueAsString();
	enm.setValue(ParticipantRequiredEnum.getByName(s));
	return enm;
	}
}
