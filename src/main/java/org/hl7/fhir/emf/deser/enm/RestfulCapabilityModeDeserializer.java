package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.RestfulCapabilityMode;
import org.hl7.fhir.RestfulCapabilityModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class RestfulCapabilityModeDeserializer extends JsonDeserializer<RestfulCapabilityMode> {

public RestfulCapabilityMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	RestfulCapabilityMode enm = FhirFactory.eINSTANCE.createRestfulCapabilityMode();
	String s = p.getValueAsString();
	enm.setValue(RestfulCapabilityModeEnum.getByName(s));
	return enm;
	}
}
