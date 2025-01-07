package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SlicingRules;
import org.hl7.fhir.SlicingRulesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SlicingRulesDeserializer extends JsonDeserializer<SlicingRules> {

public SlicingRules deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SlicingRules enm = FhirFactory.eINSTANCE.createSlicingRules();
	String s = p.getValueAsString();
	enm.setValue(SlicingRulesEnum.getByName(s));
	return enm;
	}
}
