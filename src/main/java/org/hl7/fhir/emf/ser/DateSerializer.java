package org.hl7.fhir.emf.ser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hl7.fhir.Date;
import org.hl7.fhir.emf.Finals;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		java.util.Date date = value.getValue().toGregorianCalendar().getTime();

		DateFormat YMD = new SimpleDateFormat(Finals.YMD);
		gen.writeString(YMD.format(date));
	}
}
