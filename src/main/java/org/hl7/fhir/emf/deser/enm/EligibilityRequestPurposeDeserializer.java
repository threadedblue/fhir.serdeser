package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EligibilityRequestPurpose;
import org.hl7.fhir.EligibilityRequestPurposeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EligibilityRequestPurposeDeserializer extends JsonDeserializer<EligibilityRequestPurpose> {

public EligibilityRequestPurpose deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EligibilityRequestPurpose enm = FhirFactory.eINSTANCE.createEligibilityRequestPurpose();
	String s = p.getValueAsString();
	enm.setValue(EligibilityRequestPurposeEnum.getByName(s));
	return enm;
	}
}
