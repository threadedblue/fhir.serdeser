package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.QuantityComparator;
import org.hl7.fhir.QuantityComparatorEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class QuantityComparatorDeserializer extends JsonDeserializer<QuantityComparator> {

public QuantityComparator deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	QuantityComparator enm = FhirFactory.eINSTANCE.createQuantityComparator();
	String s = p.getValueAsString();
	enm.setValue(QuantityComparatorEnum.getByName(s));
	return enm;
	}
}
