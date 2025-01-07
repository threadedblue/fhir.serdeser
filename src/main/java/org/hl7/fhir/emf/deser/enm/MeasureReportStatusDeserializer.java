package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.MeasureReportStatus;
import org.hl7.fhir.MeasureReportStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MeasureReportStatusDeserializer extends JsonDeserializer<MeasureReportStatus> {

public MeasureReportStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	MeasureReportStatus enm = FhirFactory.eINSTANCE.createMeasureReportStatus();
	String s = p.getValueAsString();
	enm.setValue(MeasureReportStatusEnum.getByName(s));
	return enm;
	}
}
