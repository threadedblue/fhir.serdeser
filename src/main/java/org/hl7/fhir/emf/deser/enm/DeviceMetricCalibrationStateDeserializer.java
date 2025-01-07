package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DeviceMetricCalibrationState;
import org.hl7.fhir.DeviceMetricCalibrationStateEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DeviceMetricCalibrationStateDeserializer extends JsonDeserializer<DeviceMetricCalibrationState> {

public DeviceMetricCalibrationState deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DeviceMetricCalibrationState enm = FhirFactory.eINSTANCE.createDeviceMetricCalibrationState();
	String s = p.getValueAsString();
	enm.setValue(DeviceMetricCalibrationStateEnum.getByName(s));
	return enm;
	}
}
