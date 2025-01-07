package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ReportRelationshipType;
import org.hl7.fhir.ReportRelationshipTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ReportRelationshipTypeDeserializer extends JsonDeserializer<ReportRelationshipType> {

public ReportRelationshipType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ReportRelationshipType enm = FhirFactory.eINSTANCE.createReportRelationshipType();
	String s = p.getValueAsString();
	enm.setValue(ReportRelationshipTypeEnum.getByName(s));
	return enm;
	}
}
