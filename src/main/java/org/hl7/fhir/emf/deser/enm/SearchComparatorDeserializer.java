package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SearchComparator;
import org.hl7.fhir.SearchComparatorEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SearchComparatorDeserializer extends JsonDeserializer<SearchComparator> {

public SearchComparator deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SearchComparator enm = FhirFactory.eINSTANCE.createSearchComparator();
	String s = p.getValueAsString();
	enm.setValue(SearchComparatorEnum.getByName(s));
	return enm;
	}
}
