package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.UnitsOfTime;
import org.hl7.fhir.UnitsOfTimeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class UnitsOfTimeDeserializer extends JsonDeserializer<UnitsOfTime> {

public UnitsOfTime deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	UnitsOfTime enm = FhirFactory.eINSTANCE.createUnitsOfTime();
	String s = p.getValueAsString();
	enm.setValue(UnitsOfTimeEnum.getByName(s));
	return enm;
	}
}
