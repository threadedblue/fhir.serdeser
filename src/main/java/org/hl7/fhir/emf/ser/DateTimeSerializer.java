package org.hl7.fhir.emf.ser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hl7.fhir.DateTime;
import org.hl7.fhir.emf.Finals;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateTimeSerializer extends JsonSerializer<DateTime> {
	
	@Override
	public void serialize(DateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		java.util.Date date = value.getValue().toGregorianCalendar().getTime();
		DateFormat YMDhms = new SimpleDateFormat(Finals.YMDhms);
		gen.writeString(YMDhms.format(date));
	}
}
