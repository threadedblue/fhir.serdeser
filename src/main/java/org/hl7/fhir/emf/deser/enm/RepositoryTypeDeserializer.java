package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.RepositoryType;
import org.hl7.fhir.RepositoryTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class RepositoryTypeDeserializer extends JsonDeserializer<RepositoryType> {

public RepositoryType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	RepositoryType enm = FhirFactory.eINSTANCE.createRepositoryType();
	String s = p.getValueAsString();
	enm.setValue(RepositoryTypeEnum.getByName(s));
	return enm;
	}
}
