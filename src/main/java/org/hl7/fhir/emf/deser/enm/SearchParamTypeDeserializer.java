package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SearchParamType;
import org.hl7.fhir.SearchParamTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SearchParamTypeDeserializer extends JsonDeserializer<SearchParamType> {

public SearchParamType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SearchParamType enm = FhirFactory.eINSTANCE.createSearchParamType();
	String s = p.getValueAsString();
	enm.setValue(SearchParamTypeEnum.getByName(s));
	return enm;
	}
}
