package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ResearchStudyStatus;
import org.hl7.fhir.ResearchStudyStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ResearchStudyStatusDeserializer extends JsonDeserializer<ResearchStudyStatus> {

public ResearchStudyStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ResearchStudyStatus enm = FhirFactory.eINSTANCE.createResearchStudyStatus();
	String s = p.getValueAsString();
	enm.setValue(ResearchStudyStatusEnum.getByName(s));
	return enm;
	}
}
