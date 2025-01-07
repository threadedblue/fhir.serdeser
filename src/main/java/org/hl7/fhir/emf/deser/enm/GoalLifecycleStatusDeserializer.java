package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.GoalLifecycleStatus;
import org.hl7.fhir.GoalLifecycleStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class GoalLifecycleStatusDeserializer extends JsonDeserializer<GoalLifecycleStatus> {

public GoalLifecycleStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	GoalLifecycleStatus enm = FhirFactory.eINSTANCE.createGoalLifecycleStatus();
	String s = p.getValueAsString();
	enm.setValue(GoalLifecycleStatusEnum.getByName(s));
	return enm;
	}
}
