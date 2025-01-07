package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ExampleScenarioActorType;
import org.hl7.fhir.ExampleScenarioActorTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ExampleScenarioActorTypeDeserializer extends JsonDeserializer<ExampleScenarioActorType> {

public ExampleScenarioActorType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ExampleScenarioActorType enm = FhirFactory.eINSTANCE.createExampleScenarioActorType();
	String s = p.getValueAsString();
	enm.setValue(ExampleScenarioActorTypeEnum.getByName(s));
	return enm;
	}
}
