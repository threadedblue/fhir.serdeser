package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AllergyIntoleranceCriticality;
import org.hl7.fhir.AllergyIntoleranceCriticalityEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AllergyIntoleranceCriticalityDeserializer extends JsonDeserializer<AllergyIntoleranceCriticality> {

public AllergyIntoleranceCriticality deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AllergyIntoleranceCriticality enm = FhirFactory.eINSTANCE.createAllergyIntoleranceCriticality();
	String s = p.getValueAsString();
	enm.setValue(AllergyIntoleranceCriticalityEnum.getByName(s));
	return enm;
	}
}
