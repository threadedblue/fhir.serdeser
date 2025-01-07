package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AggregationMode;
import org.hl7.fhir.AggregationModeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AggregationModeDeserializer extends JsonDeserializer<AggregationMode> {

public AggregationMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AggregationMode enm = FhirFactory.eINSTANCE.createAggregationMode();
	String s = p.getValueAsString();
	enm.setValue(AggregationModeEnum.getByName(s));
	return enm;
	}
}
