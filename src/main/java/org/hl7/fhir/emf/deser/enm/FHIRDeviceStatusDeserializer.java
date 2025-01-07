package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FHIRDeviceStatus;
import org.hl7.fhir.FHIRDeviceStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FHIRDeviceStatusDeserializer extends JsonDeserializer<FHIRDeviceStatus> {

public FHIRDeviceStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	FHIRDeviceStatus enm = FhirFactory.eINSTANCE.createFHIRDeviceStatus();
	String s = p.getValueAsString();
	enm.setValue(FHIRDeviceStatusEnum.getByName(s));
	return enm;
	}
}
