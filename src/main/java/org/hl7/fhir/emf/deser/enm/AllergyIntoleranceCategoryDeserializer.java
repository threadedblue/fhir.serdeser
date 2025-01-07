package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AllergyIntoleranceCategory;
import org.hl7.fhir.AllergyIntoleranceCategoryEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AllergyIntoleranceCategoryDeserializer extends JsonDeserializer<AllergyIntoleranceCategory> {

public AllergyIntoleranceCategory deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AllergyIntoleranceCategory enm = FhirFactory.eINSTANCE.createAllergyIntoleranceCategory();
	String s = p.getValueAsString();
	enm.setValue(AllergyIntoleranceCategoryEnum.getByName(s));
	return enm;
	}
}
