package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DefinitionResourceType;
import org.hl7.fhir.DefinitionResourceTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DefinitionResourceTypeDeserializer extends JsonDeserializer<DefinitionResourceType> {

public DefinitionResourceType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DefinitionResourceType enm = FhirFactory.eINSTANCE.createDefinitionResourceType();
	String s = p.getValueAsString();
	enm.setValue(DefinitionResourceTypeEnum.getByName(s));
	return enm;
	}
}
