package org.hl7.fhir.emf.ser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hl7.fhir.Time;
import org.hl7.fhir.emf.Finals;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TimeSerializer extends JsonSerializer<Time> {

	@Override
	public void serialize(org.hl7.fhir.Time value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		java.util.Date date = value.getValue().toGregorianCalendar().getTime();
		DateFormat hms = new SimpleDateFormat(Finals.hms);
		gen.writeString(hms.format(date));
	}
}
