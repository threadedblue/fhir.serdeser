package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CodeSystemContentMode;
import org.hl7.fhir.CodeSystemContentModeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CodeSystemContentModeDeserializer extends JsonDeserializer<CodeSystemContentMode> {

public CodeSystemContentMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CodeSystemContentMode enm = FhirFactory.eINSTANCE.createCodeSystemContentMode();
	String s = p.getValueAsString();
	enm.setValue(CodeSystemContentModeEnum.getByName(s));
	return enm;
	}
}
