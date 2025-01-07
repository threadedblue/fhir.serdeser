package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EventTiming;
import org.hl7.fhir.EventTimingEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EventTimingDeserializer extends JsonDeserializer<EventTiming> {

public EventTiming deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EventTiming enm = FhirFactory.eINSTANCE.createEventTiming();
	String s = p.getValueAsString();
	enm.setValue(EventTimingEnum.getByName(s));
	return enm;
	}
}
