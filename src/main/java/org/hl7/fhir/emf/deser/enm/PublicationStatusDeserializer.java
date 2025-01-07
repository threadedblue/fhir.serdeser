package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.PublicationStatus;
import org.hl7.fhir.PublicationStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PublicationStatusDeserializer extends JsonDeserializer<PublicationStatus> {

public PublicationStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	PublicationStatus enm = FhirFactory.eINSTANCE.createPublicationStatus();
	String s = p.getValueAsString();
	enm.setValue(PublicationStatusEnum.getByName(s));
	return enm;
	}
}
