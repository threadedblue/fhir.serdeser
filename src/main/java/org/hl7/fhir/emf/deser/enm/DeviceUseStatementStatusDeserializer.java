package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DeviceUseStatementStatus;
import org.hl7.fhir.DeviceUseStatementStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DeviceUseStatementStatusDeserializer extends JsonDeserializer<DeviceUseStatementStatus> {

public DeviceUseStatementStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DeviceUseStatementStatus enm = FhirFactory.eINSTANCE.createDeviceUseStatementStatus();
	String s = p.getValueAsString();
	enm.setValue(DeviceUseStatementStatusEnum.getByName(s));
	return enm;
	}
}
