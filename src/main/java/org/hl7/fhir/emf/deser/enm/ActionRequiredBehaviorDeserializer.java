package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ActionRequiredBehavior;
import org.hl7.fhir.ActionRequiredBehaviorEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ActionRequiredBehaviorDeserializer extends JsonDeserializer<ActionRequiredBehavior> {

public ActionRequiredBehavior deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ActionRequiredBehavior enm = FhirFactory.eINSTANCE.createActionRequiredBehavior();
	String s = p.getValueAsString();
	enm.setValue(ActionRequiredBehaviorEnum.getByName(s));
	return enm;
	}
}
