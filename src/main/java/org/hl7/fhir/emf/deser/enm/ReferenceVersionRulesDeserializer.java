package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ReferenceVersionRules;
import org.hl7.fhir.ReferenceVersionRulesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ReferenceVersionRulesDeserializer extends JsonDeserializer<ReferenceVersionRules> {

public ReferenceVersionRules deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ReferenceVersionRules enm = FhirFactory.eINSTANCE.createReferenceVersionRules();
	String s = p.getValueAsString();
	enm.setValue(ReferenceVersionRulesEnum.getByName(s));
	return enm;
	}
}
