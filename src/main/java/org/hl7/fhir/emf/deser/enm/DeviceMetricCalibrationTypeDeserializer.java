package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DeviceMetricCalibrationType;
import org.hl7.fhir.DeviceMetricCalibrationTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DeviceMetricCalibrationTypeDeserializer extends JsonDeserializer<DeviceMetricCalibrationType> {

public DeviceMetricCalibrationType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DeviceMetricCalibrationType enm = FhirFactory.eINSTANCE.createDeviceMetricCalibrationType();
	String s = p.getValueAsString();
	enm.setValue(DeviceMetricCalibrationTypeEnum.getByName(s));
	return enm;
	}
}
