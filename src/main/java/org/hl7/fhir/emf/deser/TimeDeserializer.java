package org.hl7.fhir.emf.deser;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.Time;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimeDeserializer extends JsonDeserializer<Time> {

	@Override
	public Time deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

		Time  time = FhirFactory.eINSTANCE.createTime();
		try {
		    String s = p.getValueAsString();
		    XMLGregorianCalendar XCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(s);
		    time.setValue(XCal);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	    return time;
	}
}
