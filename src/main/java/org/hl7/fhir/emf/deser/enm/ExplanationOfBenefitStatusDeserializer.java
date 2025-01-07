package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ExplanationOfBenefitStatus;
import org.hl7.fhir.ExplanationOfBenefitStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ExplanationOfBenefitStatusDeserializer extends JsonDeserializer<ExplanationOfBenefitStatus> {

public ExplanationOfBenefitStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ExplanationOfBenefitStatus enm = FhirFactory.eINSTANCE.createExplanationOfBenefitStatus();
	String s = p.getValueAsString();
	enm.setValue(ExplanationOfBenefitStatusEnum.getByName(s));
	return enm;
	}
}
