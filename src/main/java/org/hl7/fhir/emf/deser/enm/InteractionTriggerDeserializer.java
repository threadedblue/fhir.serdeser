package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.InteractionTrigger;
import org.hl7.fhir.InteractionTriggerEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class InteractionTriggerDeserializer extends JsonDeserializer<InteractionTrigger> {

public InteractionTrigger deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	InteractionTrigger enm = FhirFactory.eINSTANCE.createInteractionTrigger();
	String s = p.getValueAsString();
	enm.setValue(InteractionTriggerEnum.getByName(s));
	return enm;
	}
}
