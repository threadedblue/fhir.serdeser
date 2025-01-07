package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ImmunizationEvaluationStatusCodes;
import org.hl7.fhir.ImmunizationEvaluationStatusCodesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ImmunizationEvaluationStatusCodesDeserializer extends JsonDeserializer<ImmunizationEvaluationStatusCodes> {

public ImmunizationEvaluationStatusCodes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ImmunizationEvaluationStatusCodes enm = FhirFactory.eINSTANCE.createImmunizationEvaluationStatusCodes();
	String s = p.getValueAsString();
	enm.setValue(ImmunizationEvaluationStatusCodesEnum.getByName(s));
	return enm;
	}
}
