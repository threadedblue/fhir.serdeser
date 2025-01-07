package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.OperationParameterUse;
import org.hl7.fhir.OperationParameterUseEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class OperationParameterUseDeserializer extends JsonDeserializer<OperationParameterUse> {

public OperationParameterUse deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	OperationParameterUse enm = FhirFactory.eINSTANCE.createOperationParameterUse();
	String s = p.getValueAsString();
	enm.setValue(OperationParameterUseEnum.getByName(s));
	return enm;
	}
}
