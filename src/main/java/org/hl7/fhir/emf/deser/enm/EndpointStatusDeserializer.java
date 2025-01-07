package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EndpointStatus;
import org.hl7.fhir.EndpointStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EndpointStatusDeserializer extends JsonDeserializer<EndpointStatus> {

public EndpointStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EndpointStatus enm = FhirFactory.eINSTANCE.createEndpointStatus();
	String s = p.getValueAsString();
	enm.setValue(EndpointStatusEnum.getByName(s));
	return enm;
	}
}
