package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.FilterOperator;
import org.hl7.fhir.FilterOperatorEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FilterOperatorDeserializer extends JsonDeserializer<FilterOperator> {

public FilterOperator deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	FilterOperator enm = FhirFactory.eINSTANCE.createFilterOperator();
	String s = p.getValueAsString();
	enm.setValue(FilterOperatorEnum.getByName(s));
	return enm;
	}
}
