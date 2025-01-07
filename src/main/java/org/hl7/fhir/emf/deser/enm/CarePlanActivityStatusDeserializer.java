package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CarePlanActivityStatus;
import org.hl7.fhir.CarePlanActivityStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CarePlanActivityStatusDeserializer extends JsonDeserializer<CarePlanActivityStatus> {

public CarePlanActivityStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CarePlanActivityStatus enm = FhirFactory.eINSTANCE.createCarePlanActivityStatus();
	String s = p.getValueAsString();
	enm.setValue(CarePlanActivityStatusEnum.getByName(s));
	return enm;
	}
}
