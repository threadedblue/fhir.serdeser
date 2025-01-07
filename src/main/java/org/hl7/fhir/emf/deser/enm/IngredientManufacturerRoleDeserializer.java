package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.IngredientManufacturerRole;
import org.hl7.fhir.IngredientManufacturerRoleEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IngredientManufacturerRoleDeserializer extends JsonDeserializer<IngredientManufacturerRole> {

public IngredientManufacturerRole deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	IngredientManufacturerRole enm = FhirFactory.eINSTANCE.createIngredientManufacturerRole();
	String s = p.getValueAsString();
	enm.setValue(IngredientManufacturerRoleEnum.getByName(s));
	return enm;
	}
}
