package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ListStatus;
import org.hl7.fhir.ListStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ListStatusDeserializer extends JsonDeserializer<ListStatus> {

public ListStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ListStatus enm = FhirFactory.eINSTANCE.createListStatus();
	String s = p.getValueAsString();
	enm.setValue(ListStatusEnum.getByName(s));
	return enm;
	}
}
