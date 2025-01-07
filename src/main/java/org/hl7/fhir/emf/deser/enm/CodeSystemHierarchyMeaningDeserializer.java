package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CodeSystemHierarchyMeaning;
import org.hl7.fhir.CodeSystemHierarchyMeaningEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CodeSystemHierarchyMeaningDeserializer extends JsonDeserializer<CodeSystemHierarchyMeaning> {

public CodeSystemHierarchyMeaning deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CodeSystemHierarchyMeaning enm = FhirFactory.eINSTANCE.createCodeSystemHierarchyMeaning();
	String s = p.getValueAsString();
	enm.setValue(CodeSystemHierarchyMeaningEnum.getByName(s));
	return enm;
	}
}
