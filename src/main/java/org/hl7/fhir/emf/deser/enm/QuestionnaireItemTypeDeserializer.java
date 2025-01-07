package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.QuestionnaireItemType;
import org.hl7.fhir.QuestionnaireItemTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class QuestionnaireItemTypeDeserializer extends JsonDeserializer<QuestionnaireItemType> {

public QuestionnaireItemType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	QuestionnaireItemType enm = FhirFactory.eINSTANCE.createQuestionnaireItemType();
	String s = p.getValueAsString();
	enm.setValue(QuestionnaireItemTypeEnum.getByName(s));
	return enm;
	}
}
