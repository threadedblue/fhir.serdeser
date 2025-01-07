package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ActionGroupingBehavior;
import org.hl7.fhir.ActionGroupingBehaviorEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ActionGroupingBehaviorDeserializer extends JsonDeserializer<ActionGroupingBehavior> {

public ActionGroupingBehavior deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ActionGroupingBehavior enm = FhirFactory.eINSTANCE.createActionGroupingBehavior();
	String s = p.getValueAsString();
	enm.setValue(ActionGroupingBehaviorEnum.getByName(s));
	return enm;
	}
}
