package org.hl7.fhir.emf.ser;

import java.io.IOException;
import org.hl7.fhir.Integer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class IntegerSerializer extends JsonSerializer<Integer> {

	@Override
	public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeNumber(value.getValue());
	}
}
