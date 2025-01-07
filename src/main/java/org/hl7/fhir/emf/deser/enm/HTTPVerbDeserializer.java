package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.HTTPVerb;
import org.hl7.fhir.HTTPVerbEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class HTTPVerbDeserializer extends JsonDeserializer<HTTPVerb> {

public HTTPVerb deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	HTTPVerb enm = FhirFactory.eINSTANCE.createHTTPVerb();
	String s = p.getValueAsString();
	enm.setValue(HTTPVerbEnum.getByName(s));
	return enm;
	}
}
