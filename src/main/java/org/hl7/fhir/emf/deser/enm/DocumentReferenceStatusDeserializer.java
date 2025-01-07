package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DocumentReferenceStatus;
import org.hl7.fhir.DocumentReferenceStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DocumentReferenceStatusDeserializer extends JsonDeserializer<DocumentReferenceStatus> {

public DocumentReferenceStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DocumentReferenceStatus enm = FhirFactory.eINSTANCE.createDocumentReferenceStatus();
	String s = p.getValueAsString();
	enm.setValue(DocumentReferenceStatusEnum.getByName(s));
	return enm;
	}
}
