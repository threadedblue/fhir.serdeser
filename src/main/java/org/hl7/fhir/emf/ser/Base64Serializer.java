package org.hl7.fhir.emf.ser;

import java.io.IOException;
import java.util.Base64;

import org.hl7.fhir.Base64Binary;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class Base64Serializer extends JsonSerializer<Base64Binary> {

	@Override
	public void serialize(Base64Binary value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		byte[] decodedBytes = Base64.getDecoder().decode(value.getValue());
		String decodedString = new String(decodedBytes);
		gen.writeString(decodedString);
	}
}
