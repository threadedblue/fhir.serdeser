package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.MeasureReportType;
import org.hl7.fhir.MeasureReportTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MeasureReportTypeDeserializer extends JsonDeserializer<MeasureReportType> {

public MeasureReportType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	MeasureReportType enm = FhirFactory.eINSTANCE.createMeasureReportType();
	String s = p.getValueAsString();
	enm.setValue(MeasureReportTypeEnum.getByName(s));
	return enm;
	}
}
