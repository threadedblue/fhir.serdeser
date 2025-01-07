package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.QuestionnaireItemOperator;
import org.hl7.fhir.QuestionnaireItemOperatorEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class QuestionnaireItemOperatorDeserializer extends JsonDeserializer<QuestionnaireItemOperator> {

public QuestionnaireItemOperator deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	QuestionnaireItemOperator enm = FhirFactory.eINSTANCE.createQuestionnaireItemOperator();
	String s = p.getValueAsString();
	enm.setValue(QuestionnaireItemOperatorEnum.getByName(s));
	return enm;
	}
}
