package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DiagnosticReportStatus;
import org.hl7.fhir.DiagnosticReportStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DiagnosticReportStatusDeserializer extends JsonDeserializer<DiagnosticReportStatus> {

public DiagnosticReportStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DiagnosticReportStatus enm = FhirFactory.eINSTANCE.createDiagnosticReportStatus();
	String s = p.getValueAsString();
	enm.setValue(DiagnosticReportStatusEnum.getByName(s));
	return enm;
	}
}
