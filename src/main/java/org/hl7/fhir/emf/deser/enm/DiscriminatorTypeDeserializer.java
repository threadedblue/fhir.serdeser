package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.DiscriminatorType;
import org.hl7.fhir.DiscriminatorTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DiscriminatorTypeDeserializer extends JsonDeserializer<DiscriminatorType> {

public DiscriminatorType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	DiscriminatorType enm = FhirFactory.eINSTANCE.createDiscriminatorType();
	String s = p.getValueAsString();
	enm.setValue(DiscriminatorTypeEnum.getByName(s));
	return enm;
	}
}
