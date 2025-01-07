package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TestReportStatus;
import org.hl7.fhir.TestReportStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TestReportStatusDeserializer extends JsonDeserializer<TestReportStatus> {

public TestReportStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TestReportStatus enm = FhirFactory.eINSTANCE.createTestReportStatus();
	String s = p.getValueAsString();
	enm.setValue(TestReportStatusEnum.getByName(s));
	return enm;
	}
}
