package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.QuestionnaireResponseStatus;
import org.hl7.fhir.QuestionnaireResponseStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class QuestionnaireResponseStatusDeserializer extends JsonDeserializer<QuestionnaireResponseStatus> {

public QuestionnaireResponseStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	QuestionnaireResponseStatus enm = FhirFactory.eINSTANCE.createQuestionnaireResponseStatus();
	String s = p.getValueAsString();
	enm.setValue(QuestionnaireResponseStatusEnum.getByName(s));
	return enm;
	}
}
