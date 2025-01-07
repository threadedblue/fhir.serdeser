package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ExpressionLanguage;
import org.hl7.fhir.ExpressionLanguageEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ExpressionLanguageDeserializer extends JsonDeserializer<ExpressionLanguage> {

public ExpressionLanguage deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ExpressionLanguage enm = FhirFactory.eINSTANCE.createExpressionLanguage();
	String s = p.getValueAsString();
	enm.setValue(ExpressionLanguageEnum.getByName(s));
	return enm;
	}
}
