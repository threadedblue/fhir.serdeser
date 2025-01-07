package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AssertionDirectionType;
import org.hl7.fhir.AssertionDirectionTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AssertionDirectionTypeDeserializer extends JsonDeserializer<AssertionDirectionType> {

public AssertionDirectionType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AssertionDirectionType enm = FhirFactory.eINSTANCE.createAssertionDirectionType();
	String s = p.getValueAsString();
	enm.setValue(AssertionDirectionTypeEnum.getByName(s));
	return enm;
	}
}
