package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CarePlanActivityKind;
import org.hl7.fhir.CarePlanActivityKindEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CarePlanActivityKindDeserializer extends JsonDeserializer<CarePlanActivityKind> {

public CarePlanActivityKind deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CarePlanActivityKind enm = FhirFactory.eINSTANCE.createCarePlanActivityKind();
	String s = p.getValueAsString();
	enm.setValue(CarePlanActivityKindEnum.getByName(s));
	return enm;
	}
}
