 package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.hl7.fhir.Bundle;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BundleDeserializer extends JsonDeserializer<Bundle> {

	@Override
	public Bundle deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
			p.nextToken();
		}

		return FhirFactory.eINSTANCE.createBundle();
	}
}
