package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DeviceMetricOperationalStatus;
import org.hl7.fhir.DeviceMetricOperationalStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DeviceMetricOperationalStatusDeserializer extends JsonDeserializer<DeviceMetricOperationalStatus> {

public DeviceMetricOperationalStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DeviceMetricOperationalStatus enm = FhirFactory.eINSTANCE.createDeviceMetricOperationalStatus();
	String s = p.getValueAsString();
	enm.setValue(DeviceMetricOperationalStatusEnum.getByName(s));
	return enm;
	}
}
