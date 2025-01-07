package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.OperationKind;
import org.hl7.fhir.OperationKindEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class OperationKindDeserializer extends JsonDeserializer<OperationKind> {

public OperationKind deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	OperationKind enm = FhirFactory.eINSTANCE.createOperationKind();
	String s = p.getValueAsString();
	enm.setValue(OperationKindEnum.getByName(s));
	return enm;
	}
}
