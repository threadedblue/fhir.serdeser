package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.Status;
import org.hl7.fhir.StatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StatusDeserializer extends JsonDeserializer<Status> {

public Status deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	Status enm = FhirFactory.eINSTANCE.createStatus();
	String s = p.getValueAsString();
	enm.setValue(StatusEnum.getByName(s));
	return enm;
	}
}
