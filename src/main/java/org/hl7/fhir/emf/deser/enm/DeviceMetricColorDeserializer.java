package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DeviceMetricColor;
import org.hl7.fhir.DeviceMetricColorEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DeviceMetricColorDeserializer extends JsonDeserializer<DeviceMetricColor> {

public DeviceMetricColor deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DeviceMetricColor enm = FhirFactory.eINSTANCE.createDeviceMetricColor();
	String s = p.getValueAsString();
	enm.setValue(DeviceMetricColorEnum.getByName(s));
	return enm;
	}
}
