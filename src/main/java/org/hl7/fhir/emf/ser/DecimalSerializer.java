package org.hl7.fhir.emf.ser;

import java.io.IOException;

import org.hl7.fhir.Decimal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DecimalSerializer extends JsonSerializer<Decimal> {

	@Override
	public void serialize(Decimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeNumber(((Float)value.getValue()).floatValue());
	}
}
