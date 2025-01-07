package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EventOrRequestResourceTypes;
import org.hl7.fhir.EventOrRequestResourceTypesEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EventOrRequestResourceTypesDeserializer extends JsonDeserializer<EventOrRequestResourceTypes> {

public EventOrRequestResourceTypes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EventOrRequestResourceTypes enm = FhirFactory.eINSTANCE.createEventOrRequestResourceTypes();
	String s = p.getValueAsString();
	enm.setValue(EventOrRequestResourceTypesEnum.getByName(s));
	return enm;
	}
}
