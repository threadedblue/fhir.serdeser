package org.hl7.fhir.emf.ser;

import java.io.IOException;

import org.hl7.fhir.Uri;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UriSerializer extends JsonSerializer<Uri> {

	@Override
	public void serialize(Uri value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getValue());
	}
}
