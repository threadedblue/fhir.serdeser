package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TestReportActionResult;
import org.hl7.fhir.TestReportActionResultEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TestReportActionResultDeserializer extends JsonDeserializer<TestReportActionResult> {

public TestReportActionResult deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TestReportActionResult enm = FhirFactory.eINSTANCE.createTestReportActionResult();
	String s = p.getValueAsString();
	enm.setValue(TestReportActionResultEnum.getByName(s));
	return enm;
	}
}
