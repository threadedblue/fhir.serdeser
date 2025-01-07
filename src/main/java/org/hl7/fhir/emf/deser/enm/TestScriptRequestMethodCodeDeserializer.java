package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TestScriptRequestMethodCode;
import org.hl7.fhir.TestScriptRequestMethodCodeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TestScriptRequestMethodCodeDeserializer extends JsonDeserializer<TestScriptRequestMethodCode> {

public TestScriptRequestMethodCode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TestScriptRequestMethodCode enm = FhirFactory.eINSTANCE.createTestScriptRequestMethodCode();
	String s = p.getValueAsString();
	enm.setValue(TestScriptRequestMethodCodeEnum.getByName(s));
	return enm;
	}
}
