package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ActionPrecheckBehavior;
import org.hl7.fhir.ActionPrecheckBehaviorEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ActionPrecheckBehaviorDeserializer extends JsonDeserializer<ActionPrecheckBehavior> {

public ActionPrecheckBehavior deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ActionPrecheckBehavior enm = FhirFactory.eINSTANCE.createActionPrecheckBehavior();
	String s = p.getValueAsString();
	enm.setValue(ActionPrecheckBehaviorEnum.getByName(s));
	return enm;
	}
}
