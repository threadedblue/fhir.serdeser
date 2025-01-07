package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.IssueType;
import org.hl7.fhir.IssueTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IssueTypeDeserializer extends JsonDeserializer<IssueType> {

public IssueType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	IssueType enm = FhirFactory.eINSTANCE.createIssueType();
	String s = p.getValueAsString();
	enm.setValue(IssueTypeEnum.getByName(s));
	return enm;
	}
}
