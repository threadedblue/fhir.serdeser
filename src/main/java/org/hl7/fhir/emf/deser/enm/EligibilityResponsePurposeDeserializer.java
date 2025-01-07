package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EligibilityResponsePurpose;
import org.hl7.fhir.EligibilityResponsePurposeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EligibilityResponsePurposeDeserializer extends JsonDeserializer<EligibilityResponsePurpose> {

public EligibilityResponsePurpose deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EligibilityResponsePurpose enm = FhirFactory.eINSTANCE.createEligibilityResponsePurpose();
	String s = p.getValueAsString();
	enm.setValue(EligibilityResponsePurposeEnum.getByName(s));
	return enm;
	}
}
