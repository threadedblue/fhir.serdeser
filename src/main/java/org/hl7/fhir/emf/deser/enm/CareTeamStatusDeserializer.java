package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CareTeamStatus;
import org.hl7.fhir.CareTeamStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CareTeamStatusDeserializer extends JsonDeserializer<CareTeamStatus> {

public CareTeamStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CareTeamStatus enm = FhirFactory.eINSTANCE.createCareTeamStatus();
	String s = p.getValueAsString();
	enm.setValue(CareTeamStatusEnum.getByName(s));
	return enm;
	}
}
