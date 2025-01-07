package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AllergyIntoleranceType;
import org.hl7.fhir.AllergyIntoleranceTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AllergyIntoleranceTypeDeserializer extends JsonDeserializer<AllergyIntoleranceType> {

public AllergyIntoleranceType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AllergyIntoleranceType enm = FhirFactory.eINSTANCE.createAllergyIntoleranceType();
	String s = p.getValueAsString();
	enm.setValue(AllergyIntoleranceTypeEnum.getByName(s));
	return enm;
	}
}
