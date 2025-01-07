package org.hl7.fhir.emf.deser;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hl7.fhir.DateTime;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateTimeDeserializer extends JsonDeserializer<DateTime> {

	@Override
	public DateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

		DateTime dateTime = FhirFactory.eINSTANCE.createDateTime();
		try {
		    String s = p.getValueAsString();
		    XMLGregorianCalendar XCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(s);
		    dateTime.setValue(XCal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	    return dateTime;
	}
}
