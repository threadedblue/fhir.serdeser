package org.hl7.fhir.emf.deser;

import java.io.IOException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.Instant;
import org.hl7.fhir.emf.Finals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class InstantDeserializer extends JsonDeserializer<Instant> {
	
	private static final Logger LOG = LoggerFactory.getLogger(InstantDeserializer.class);
	
	@Override
	public Instant deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

		Instant instant = FhirFactory.eINSTANCE.createInstant();
		try {
		    String s = p.getValueAsString();
		    XMLGregorianCalendar XCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(s);
		    instant.setValue(XCal);
		} catch (IOException e) {
			LOG.error("Date=" + p.getValueAsString() + " Format=" + Finals.YMDhms);
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	    return instant;
	}
}
