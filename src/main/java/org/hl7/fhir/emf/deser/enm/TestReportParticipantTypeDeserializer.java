package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TestReportParticipantType;
import org.hl7.fhir.TestReportParticipantTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TestReportParticipantTypeDeserializer extends JsonDeserializer<TestReportParticipantType> {

public TestReportParticipantType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TestReportParticipantType enm = FhirFactory.eINSTANCE.createTestReportParticipantType();
	String s = p.getValueAsString();
	enm.setValue(TestReportParticipantTypeEnum.getByName(s));
	return enm;
	}
}
