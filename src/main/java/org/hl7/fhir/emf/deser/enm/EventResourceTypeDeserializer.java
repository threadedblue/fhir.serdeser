package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EventResourceType;
import org.hl7.fhir.EventResourceTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EventResourceTypeDeserializer extends JsonDeserializer<EventResourceType> {

public EventResourceType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EventResourceType enm = FhirFactory.eINSTANCE.createEventResourceType();
	String s = p.getValueAsString();
	enm.setValue(EventResourceTypeEnum.getByName(s));
	return enm;
	}
}
