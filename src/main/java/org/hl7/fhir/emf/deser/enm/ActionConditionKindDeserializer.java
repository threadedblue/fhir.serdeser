package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ActionConditionKind;
import org.hl7.fhir.ActionConditionKindEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ActionConditionKindDeserializer extends JsonDeserializer<ActionConditionKind> {

public ActionConditionKind deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ActionConditionKind enm = FhirFactory.eINSTANCE.createActionConditionKind();
	String s = p.getValueAsString();
	enm.setValue(ActionConditionKindEnum.getByName(s));
	return enm;
	}
}
