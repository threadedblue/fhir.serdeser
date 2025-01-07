package org.hl7.fhir.emf.ser;

import java.io.IOException;

import org.hl7.fhir.Code;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CodeSerializer extends JsonSerializer<Code> {

	@Override
	public void serialize(Code value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getValue());
	}
}