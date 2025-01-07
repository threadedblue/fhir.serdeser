package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SearchEntryMode;
import org.hl7.fhir.SearchEntryModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SearchEntryModeDeserializer extends JsonDeserializer<SearchEntryMode> {

public SearchEntryMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SearchEntryMode enm = FhirFactory.eINSTANCE.createSearchEntryMode();
	String s = p.getValueAsString();
	enm.setValue(SearchEntryModeEnum.getByName(s));
	return enm;
	}
}
