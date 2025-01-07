 package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.hl7.fhir.BundleEntry;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BundleEntryDeserializer extends JsonDeserializer<BundleEntry> {

	public BundleEntryDeserializer() {
	}

	@Override
	public BundleEntry deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
			p.nextToken();
		}

		return FhirFactory.eINSTANCE.createBundleEntry();
	}
}
