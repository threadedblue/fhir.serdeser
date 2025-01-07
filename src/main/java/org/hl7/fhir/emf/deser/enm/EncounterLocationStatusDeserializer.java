package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EncounterLocationStatus;
import org.hl7.fhir.EncounterLocationStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EncounterLocationStatusDeserializer extends JsonDeserializer<EncounterLocationStatus> {

public EncounterLocationStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EncounterLocationStatus enm = FhirFactory.eINSTANCE.createEncounterLocationStatus();
	String s = p.getValueAsString();
	enm.setValue(EncounterLocationStatusEnum.getByName(s));
	return enm;
	}
}
