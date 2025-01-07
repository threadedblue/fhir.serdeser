package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EncounterStatus;
import org.hl7.fhir.EncounterStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EncounterStatusDeserializer extends JsonDeserializer<EncounterStatus> {

public EncounterStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EncounterStatus enm = FhirFactory.eINSTANCE.createEncounterStatus();
	String s = p.getValueAsString();
	enm.setValue(EncounterStatusEnum.getByName(s));
	return enm;
	}
}
