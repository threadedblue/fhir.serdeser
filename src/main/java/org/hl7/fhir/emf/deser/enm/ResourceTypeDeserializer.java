package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ResourceType;
import org.hl7.fhir.ResourceTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ResourceTypeDeserializer extends JsonDeserializer<ResourceType> {

public ResourceType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ResourceType enm = FhirFactory.eINSTANCE.createResourceType();
	String s = p.getValueAsString();
	enm.setValue(ResourceTypeEnum.getByName(s));
	return enm;
	}
}
