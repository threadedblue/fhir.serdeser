package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.hl7.fhir.Base64Binary;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class Base64Deserializer extends JsonDeserializer<Base64Binary> {

	@Override
	public Base64Binary deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

		Base64Binary B64 = FhirFactory.eINSTANCE.createBase64Binary();
	    B64.setValue(p.getBinaryValue(null));
	    return B64;
	}

}
