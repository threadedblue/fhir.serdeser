package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SequenceType;
import org.hl7.fhir.SequenceTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SequenceTypeDeserializer extends JsonDeserializer<SequenceType> {

public SequenceType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SequenceType enm = FhirFactory.eINSTANCE.createSequenceType();
	String s = p.getValueAsString();
	enm.setValue(SequenceTypeEnum.getByName(s));
	return enm;
	}
}
