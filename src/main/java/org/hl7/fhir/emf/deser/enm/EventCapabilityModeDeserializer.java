package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EventCapabilityMode;
import org.hl7.fhir.EventCapabilityModeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EventCapabilityModeDeserializer extends JsonDeserializer<EventCapabilityMode> {

public EventCapabilityMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EventCapabilityMode enm = FhirFactory.eINSTANCE.createEventCapabilityMode();
	String s = p.getValueAsString();
	enm.setValue(EventCapabilityModeEnum.getByName(s));
	return enm;
	}
}
