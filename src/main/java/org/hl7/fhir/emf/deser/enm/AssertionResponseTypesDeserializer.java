package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AssertionResponseTypes;
import org.hl7.fhir.AssertionResponseTypesEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AssertionResponseTypesDeserializer extends JsonDeserializer<AssertionResponseTypes> {

public AssertionResponseTypes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AssertionResponseTypes enm = FhirFactory.eINSTANCE.createAssertionResponseTypes();
	String s = p.getValueAsString();
	enm.setValue(AssertionResponseTypesEnum.getByName(s));
	return enm;
	}
}
