package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ObservationStatus;
import org.hl7.fhir.ObservationStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ObservationStatusDeserializer extends JsonDeserializer<ObservationStatus> {

public ObservationStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ObservationStatus enm = FhirFactory.eINSTANCE.createObservationStatus();
	String s = p.getValueAsString();
	enm.setValue(ObservationStatusEnum.getByName(s));
	return enm;
	}
}
