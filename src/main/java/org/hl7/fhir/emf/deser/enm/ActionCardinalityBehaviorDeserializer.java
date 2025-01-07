package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ActionCardinalityBehavior;
import org.hl7.fhir.ActionCardinalityBehaviorEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ActionCardinalityBehaviorDeserializer extends JsonDeserializer<ActionCardinalityBehavior> {

public ActionCardinalityBehavior deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ActionCardinalityBehavior enm = FhirFactory.eINSTANCE.createActionCardinalityBehavior();
	String s = p.getValueAsString();
	enm.setValue(ActionCardinalityBehaviorEnum.getByName(s));
	return enm;
	}
}
