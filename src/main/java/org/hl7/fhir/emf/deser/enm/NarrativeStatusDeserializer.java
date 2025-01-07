package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.NarrativeStatus;
import org.hl7.fhir.NarrativeStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NarrativeStatusDeserializer extends JsonDeserializer<NarrativeStatus> {

public NarrativeStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	NarrativeStatus enm = FhirFactory.eINSTANCE.createNarrativeStatus();
	String s = p.getValueAsString();
	enm.setValue(NarrativeStatusEnum.getByName(s));
	return enm;
	}
}
