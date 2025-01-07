package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TestReportResult;
import org.hl7.fhir.TestReportResultEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TestReportResultDeserializer extends JsonDeserializer<TestReportResult> {

public TestReportResult deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TestReportResult enm = FhirFactory.eINSTANCE.createTestReportResult();
	String s = p.getValueAsString();
	enm.setValue(TestReportResultEnum.getByName(s));
	return enm;
	}
}
