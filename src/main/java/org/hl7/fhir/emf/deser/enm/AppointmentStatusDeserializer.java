package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AppointmentStatus;
import org.hl7.fhir.AppointmentStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AppointmentStatusDeserializer extends JsonDeserializer<AppointmentStatus> {

public AppointmentStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AppointmentStatus enm = FhirFactory.eINSTANCE.createAppointmentStatus();
	String s = p.getValueAsString();
	enm.setValue(AppointmentStatusEnum.getByName(s));
	return enm;
	}
}
