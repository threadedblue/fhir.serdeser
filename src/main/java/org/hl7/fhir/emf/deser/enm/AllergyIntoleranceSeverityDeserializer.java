package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AllergyIntoleranceSeverity;
import org.hl7.fhir.AllergyIntoleranceSeverityEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AllergyIntoleranceSeverityDeserializer extends JsonDeserializer<AllergyIntoleranceSeverity> {

public AllergyIntoleranceSeverity deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AllergyIntoleranceSeverity enm = FhirFactory.eINSTANCE.createAllergyIntoleranceSeverity();
	String s = p.getValueAsString();
	enm.setValue(AllergyIntoleranceSeverityEnum.getByName(s));
	return enm;
	}
}
