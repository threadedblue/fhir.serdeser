package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DocumentRelationshipType;
import org.hl7.fhir.DocumentRelationshipTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DocumentRelationshipTypeDeserializer extends JsonDeserializer<DocumentRelationshipType> {

public DocumentRelationshipType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DocumentRelationshipType enm = FhirFactory.eINSTANCE.createDocumentRelationshipType();
	String s = p.getValueAsString();
	enm.setValue(DocumentRelationshipTypeEnum.getByName(s));
	return enm;
	}
}
