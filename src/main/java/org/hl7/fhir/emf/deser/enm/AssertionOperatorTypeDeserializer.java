package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AssertionOperatorType;
import org.hl7.fhir.AssertionOperatorTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AssertionOperatorTypeDeserializer extends JsonDeserializer<AssertionOperatorType> {

public AssertionOperatorType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AssertionOperatorType enm = FhirFactory.eINSTANCE.createAssertionOperatorType();
	String s = p.getValueAsString();
	enm.setValue(AssertionOperatorTypeEnum.getByName(s));
	return enm;
	}
}
