package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.NamingSystemType;
import org.hl7.fhir.NamingSystemTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NamingSystemTypeDeserializer extends JsonDeserializer<NamingSystemType> {

public NamingSystemType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	NamingSystemType enm = FhirFactory.eINSTANCE.createNamingSystemType();
	String s = p.getValueAsString();
	enm.setValue(NamingSystemTypeEnum.getByName(s));
	return enm;
	}
}
