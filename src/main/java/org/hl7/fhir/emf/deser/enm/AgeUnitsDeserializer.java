package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AgeUnits;
import org.hl7.fhir.AgeUnitsEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AgeUnitsDeserializer extends JsonDeserializer<AgeUnits> {

public AgeUnits deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AgeUnits enm = FhirFactory.eINSTANCE.createAgeUnits();
	String s = p.getValueAsString();
	enm.setValue(AgeUnitsEnum.getByName(s));
	return enm;
	}
}
