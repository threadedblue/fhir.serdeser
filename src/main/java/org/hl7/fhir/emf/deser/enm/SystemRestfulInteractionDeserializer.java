package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SystemRestfulInteraction;
import org.hl7.fhir.SystemRestfulInteractionEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SystemRestfulInteractionDeserializer extends JsonDeserializer<SystemRestfulInteraction> {

public SystemRestfulInteraction deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SystemRestfulInteraction enm = FhirFactory.eINSTANCE.createSystemRestfulInteraction();
	String s = p.getValueAsString();
	enm.setValue(SystemRestfulInteractionEnum.getByName(s));
	return enm;
	}
}
