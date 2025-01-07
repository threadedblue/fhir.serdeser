package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.RequestPriority;
import org.hl7.fhir.RequestPriorityEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class RequestPriorityDeserializer extends JsonDeserializer<RequestPriority> {

public RequestPriority deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	RequestPriority enm = FhirFactory.eINSTANCE.createRequestPriority();
	String s = p.getValueAsString();
	enm.setValue(RequestPriorityEnum.getByName(s));
	return enm;
	}
}
