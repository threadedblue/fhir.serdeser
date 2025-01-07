package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ResponseType;
import org.hl7.fhir.ResponseTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ResponseTypeDeserializer extends JsonDeserializer<ResponseType> {

public ResponseType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ResponseType enm = FhirFactory.eINSTANCE.createResponseType();
	String s = p.getValueAsString();
	enm.setValue(ResponseTypeEnum.getByName(s));
	return enm;
	}
}
