package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CarePlanIntent;
import org.hl7.fhir.CarePlanIntentEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CarePlanIntentDeserializer extends JsonDeserializer<CarePlanIntent> {

public CarePlanIntent deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CarePlanIntent enm = FhirFactory.eINSTANCE.createCarePlanIntent();
	String s = p.getValueAsString();
	enm.setValue(CarePlanIntentEnum.getByName(s));
	return enm;
	}
}
