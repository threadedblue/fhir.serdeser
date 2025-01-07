package org.hl7.fhir.emf.ser;

import java.io.IOException;

import org.hl7.fhir.Url;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UrlSerializer extends JsonSerializer<Url> {

	@Override
	public void serialize(Url value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getValue());
	}
}
