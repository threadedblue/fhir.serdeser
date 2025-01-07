package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ObservationRangeCategory;
import org.hl7.fhir.ObservationRangeCategoryEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ObservationRangeCategoryDeserializer extends JsonDeserializer<ObservationRangeCategory> {

public ObservationRangeCategory deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ObservationRangeCategory enm = FhirFactory.eINSTANCE.createObservationRangeCategory();
	String s = p.getValueAsString();
	enm.setValue(ObservationRangeCategoryEnum.getByName(s));
	return enm;
	}
}
