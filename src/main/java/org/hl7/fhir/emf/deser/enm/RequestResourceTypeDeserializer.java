package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.RequestResourceType;
import org.hl7.fhir.RequestResourceTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class RequestResourceTypeDeserializer extends JsonDeserializer<RequestResourceType> {

public RequestResourceType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	RequestResourceType enm = FhirFactory.eINSTANCE.createRequestResourceType();
	String s = p.getValueAsString();
	enm.setValue(RequestResourceTypeEnum.getByName(s));
	return enm;
	}
}
