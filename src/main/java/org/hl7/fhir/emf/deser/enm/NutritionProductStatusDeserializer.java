package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.NutritionProductStatus;
import org.hl7.fhir.NutritionProductStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NutritionProductStatusDeserializer extends JsonDeserializer<NutritionProductStatus> {

public NutritionProductStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	NutritionProductStatus enm = FhirFactory.eINSTANCE.createNutritionProductStatus();
	String s = p.getValueAsString();
	enm.setValue(NutritionProductStatusEnum.getByName(s));
	return enm;
	}
}
