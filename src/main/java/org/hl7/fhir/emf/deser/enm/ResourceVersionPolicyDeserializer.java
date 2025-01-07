package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ResourceVersionPolicy;
import org.hl7.fhir.ResourceVersionPolicyEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ResourceVersionPolicyDeserializer extends JsonDeserializer<ResourceVersionPolicy> {

public ResourceVersionPolicy deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ResourceVersionPolicy enm = FhirFactory.eINSTANCE.createResourceVersionPolicy();
	String s = p.getValueAsString();
	enm.setValue(ResourceVersionPolicyEnum.getByName(s));
	return enm;
	}
}
