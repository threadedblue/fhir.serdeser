package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DeviceNameType;
import org.hl7.fhir.DeviceNameTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DeviceNameTypeDeserializer extends JsonDeserializer<DeviceNameType> {

public DeviceNameType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DeviceNameType enm = FhirFactory.eINSTANCE.createDeviceNameType();
	String s = p.getValueAsString();
	enm.setValue(DeviceNameTypeEnum.getByName(s));
	return enm;
	}
}
