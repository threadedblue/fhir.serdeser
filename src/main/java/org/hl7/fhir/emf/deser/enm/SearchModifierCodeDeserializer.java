package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SearchModifierCode;
import org.hl7.fhir.SearchModifierCodeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SearchModifierCodeDeserializer extends JsonDeserializer<SearchModifierCode> {

public SearchModifierCode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SearchModifierCode enm = FhirFactory.eINSTANCE.createSearchModifierCode();
	String s = p.getValueAsString();
	enm.setValue(SearchModifierCodeEnum.getByName(s));
	return enm;
	}
}
