package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.hl7.fhir.Code;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CodeDeserializer extends JsonDeserializer<Code> {

	@Override
	public Code deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

	    Code cd = FhirFactory.eINSTANCE.createCode();
	    cd.setValue(p.getValueAsString());
	    return cd;
	}
}
