package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SortDirection;
import org.hl7.fhir.SortDirectionEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SortDirectionDeserializer extends JsonDeserializer<SortDirection> {

public SortDirection deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SortDirection enm = FhirFactory.eINSTANCE.createSortDirection();
	String s = p.getValueAsString();
	enm.setValue(SortDirectionEnum.getByName(s));
	return enm;
	}
}
