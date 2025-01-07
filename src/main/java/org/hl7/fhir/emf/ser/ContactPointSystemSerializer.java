package org.hl7.fhir.emf.ser;

import java.io.IOException;

import org.hl7.fhir.ContactPointSystem;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ContactPointSystemSerializer extends JsonSerializer<ContactPointSystem> {

	@Override
	public void serialize(ContactPointSystem value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value.getValue().getLiteral());
	}
}
