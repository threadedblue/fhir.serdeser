package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.Confidentiality;
import org.hl7.fhir.ConfidentialityEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConfidentialityDeserializer extends JsonDeserializer<Confidentiality> {

public Confidentiality deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	Confidentiality enm = FhirFactory.eINSTANCE.createConfidentiality();
	String s = p.getValueAsString();
	enm.setValue(ConfidentialityEnum.getByName(s));
	return enm;
	}
}
