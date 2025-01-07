package org.hl7.fhir.emf.ser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hl7.fhir.emf.Finals;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class InstantSerializer extends JsonSerializer<org.hl7.fhir.Instant> {

	@Override
	public void serialize(org.hl7.fhir.Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		java.util.Date date = value.getValue().toGregorianCalendar().getTime();
		DateFormat YMDhms = new SimpleDateFormat(Finals.YMDhms);
		gen.writeString(YMDhms.format(date));
	}
}
