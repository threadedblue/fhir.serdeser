package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DocumentMode;
import org.hl7.fhir.DocumentModeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DocumentModeDeserializer extends JsonDeserializer<DocumentMode> {

public DocumentMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DocumentMode enm = FhirFactory.eINSTANCE.createDocumentMode();
	String s = p.getValueAsString();
	enm.setValue(DocumentModeEnum.getByName(s));
	return enm;
	}
}
