package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.Uri;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class UriDeserializer extends JsonDeserializer<Uri> {

	@Override
	public Uri deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

	    Uri uri = FhirFactory.eINSTANCE.createUri();
	    uri.setValue(p.getValueAsString());
	    return uri;
	}
}
