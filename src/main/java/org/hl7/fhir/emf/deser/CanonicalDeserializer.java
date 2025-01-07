package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.hl7.fhir.Canonical;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CanonicalDeserializer extends JsonDeserializer<Canonical> {

	@Override
	public Canonical deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

	    Canonical can = FhirFactory.eINSTANCE.createCanonical();
	    can.setValue(p.getValueAsString());
	    return can;
	}
}
