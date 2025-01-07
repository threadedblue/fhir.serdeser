package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TaskStatus;
import org.hl7.fhir.TaskStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TaskStatusDeserializer extends JsonDeserializer<TaskStatus> {

public TaskStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TaskStatus enm = FhirFactory.eINSTANCE.createTaskStatus();
	String s = p.getValueAsString();
	enm.setValue(TaskStatusEnum.getByName(s));
	return enm;
	}
}
