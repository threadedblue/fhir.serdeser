package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ActionSelectionBehavior;
import org.hl7.fhir.ActionSelectionBehaviorEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ActionSelectionBehaviorDeserializer extends JsonDeserializer<ActionSelectionBehavior> {

public ActionSelectionBehavior deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ActionSelectionBehavior enm = FhirFactory.eINSTANCE.createActionSelectionBehavior();
	String s = p.getValueAsString();
	enm.setValue(ActionSelectionBehaviorEnum.getByName(s));
	return enm;
	}
}
