package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.Url;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class UrlDeserializer extends JsonDeserializer<Url> {

	@Override
	public Url deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

	    Url url = FhirFactory.eINSTANCE.createUrl();
	    url.setValue(p.getValueAsString());
	    return url;
	}
}
