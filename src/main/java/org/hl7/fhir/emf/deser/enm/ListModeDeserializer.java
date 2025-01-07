package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ListMode;
import org.hl7.fhir.ListModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ListModeDeserializer extends JsonDeserializer<ListMode> {

public ListMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ListMode enm = FhirFactory.eINSTANCE.createListMode();
	String s = p.getValueAsString();
	enm.setValue(ListModeEnum.getByName(s));
	return enm;
	}
}
