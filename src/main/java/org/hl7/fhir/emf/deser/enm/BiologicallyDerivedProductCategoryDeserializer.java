package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.BiologicallyDerivedProductCategory;
import org.hl7.fhir.BiologicallyDerivedProductCategoryEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BiologicallyDerivedProductCategoryDeserializer extends JsonDeserializer<BiologicallyDerivedProductCategory> {

public BiologicallyDerivedProductCategory deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	BiologicallyDerivedProductCategory enm = FhirFactory.eINSTANCE.createBiologicallyDerivedProductCategory();
	String s = p.getValueAsString();
	enm.setValue(BiologicallyDerivedProductCategoryEnum.getByName(s));
	return enm;
	}
}
