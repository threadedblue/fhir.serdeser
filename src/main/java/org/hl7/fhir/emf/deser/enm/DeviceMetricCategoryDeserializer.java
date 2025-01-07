package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DeviceMetricCategory;
import org.hl7.fhir.DeviceMetricCategoryEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DeviceMetricCategoryDeserializer extends JsonDeserializer<DeviceMetricCategory> {

public DeviceMetricCategory deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DeviceMetricCategory enm = FhirFactory.eINSTANCE.createDeviceMetricCategory();
	String s = p.getValueAsString();
	enm.setValue(DeviceMetricCategoryEnum.getByName(s));
	return enm;
	}
}
