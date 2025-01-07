package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EventStatus;
import org.hl7.fhir.EventStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EventStatusDeserializer extends JsonDeserializer<EventStatus> {

public EventStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EventStatus enm = FhirFactory.eINSTANCE.createEventStatus();
	String s = p.getValueAsString();
	enm.setValue(EventStatusEnum.getByName(s));
	return enm;
	}
}
