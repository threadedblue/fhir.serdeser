package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SpecimenStatus;
import org.hl7.fhir.SpecimenStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SpecimenStatusDeserializer extends JsonDeserializer<SpecimenStatus> {

public SpecimenStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SpecimenStatus enm = FhirFactory.eINSTANCE.createSpecimenStatus();
	String s = p.getValueAsString();
	enm.setValue(SpecimenStatusEnum.getByName(s));
	return enm;
	}
}
