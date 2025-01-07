package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.BindingStrength;
import org.hl7.fhir.BindingStrengthEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BindingStrengthDeserializer extends JsonDeserializer<BindingStrength> {

public BindingStrength deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	BindingStrength enm = FhirFactory.eINSTANCE.createBindingStrength();
	String s = p.getValueAsString();
	enm.setValue(BindingStrengthEnum.getByName(s));
	return enm;
	}
}
