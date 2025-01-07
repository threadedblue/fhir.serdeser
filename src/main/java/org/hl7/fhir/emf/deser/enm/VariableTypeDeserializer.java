package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.VariableType;
import org.hl7.fhir.VariableTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class VariableTypeDeserializer extends JsonDeserializer<VariableType> {

public VariableType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	VariableType enm = FhirFactory.eINSTANCE.createVariableType();
	String s = p.getValueAsString();
	enm.setValue(VariableTypeEnum.getByName(s));
	return enm;
	}
}
