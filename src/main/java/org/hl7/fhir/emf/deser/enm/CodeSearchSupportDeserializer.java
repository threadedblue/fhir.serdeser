package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CodeSearchSupport;
import org.hl7.fhir.CodeSearchSupportEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CodeSearchSupportDeserializer extends JsonDeserializer<CodeSearchSupport> {

public CodeSearchSupport deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CodeSearchSupport enm = FhirFactory.eINSTANCE.createCodeSearchSupport();
	String s = p.getValueAsString();
	enm.setValue(CodeSearchSupportEnum.getByName(s));
	return enm;
	}
}
