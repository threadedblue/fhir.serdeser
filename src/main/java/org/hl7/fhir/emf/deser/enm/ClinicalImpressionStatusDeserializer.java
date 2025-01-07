package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ClinicalImpressionStatus;
import org.hl7.fhir.ClinicalImpressionStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ClinicalImpressionStatusDeserializer extends JsonDeserializer<ClinicalImpressionStatus> {

public ClinicalImpressionStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ClinicalImpressionStatus enm = FhirFactory.eINSTANCE.createClinicalImpressionStatus();
	String s = p.getValueAsString();
	enm.setValue(ClinicalImpressionStatusEnum.getByName(s));
	return enm;
	}
}
