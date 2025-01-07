package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ResearchSubjectStatus;
import org.hl7.fhir.ResearchSubjectStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ResearchSubjectStatusDeserializer extends JsonDeserializer<ResearchSubjectStatus> {

public ResearchSubjectStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ResearchSubjectStatus enm = FhirFactory.eINSTANCE.createResearchSubjectStatus();
	String s = p.getValueAsString();
	enm.setValue(ResearchSubjectStatusEnum.getByName(s));
	return enm;
	}
}
