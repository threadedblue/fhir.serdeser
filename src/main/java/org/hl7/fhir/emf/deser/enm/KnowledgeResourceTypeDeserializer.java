package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.KnowledgeResourceType;
import org.hl7.fhir.KnowledgeResourceTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class KnowledgeResourceTypeDeserializer extends JsonDeserializer<KnowledgeResourceType> {

public KnowledgeResourceType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	KnowledgeResourceType enm = FhirFactory.eINSTANCE.createKnowledgeResourceType();
	String s = p.getValueAsString();
	enm.setValue(KnowledgeResourceTypeEnum.getByName(s));
	return enm;
	}
}
