package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TaskIntent;
import org.hl7.fhir.TaskIntentEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TaskIntentDeserializer extends JsonDeserializer<TaskIntent> {

public TaskIntent deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TaskIntent enm = FhirFactory.eINSTANCE.createTaskIntent();
	String s = p.getValueAsString();
	enm.setValue(TaskIntentEnum.getByName(s));
	return enm;
	}
}
