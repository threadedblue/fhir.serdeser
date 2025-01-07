package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.RequestStatus;
import org.hl7.fhir.RequestStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class RequestStatusDeserializer extends JsonDeserializer<RequestStatus> {

public RequestStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	RequestStatus enm = FhirFactory.eINSTANCE.createRequestStatus();
	String s = p.getValueAsString();
	enm.setValue(RequestStatusEnum.getByName(s));
	return enm;
	}
}
