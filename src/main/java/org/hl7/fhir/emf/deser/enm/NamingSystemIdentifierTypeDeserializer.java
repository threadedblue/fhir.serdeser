package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.NamingSystemIdentifierType;
import org.hl7.fhir.NamingSystemIdentifierTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NamingSystemIdentifierTypeDeserializer extends JsonDeserializer<NamingSystemIdentifierType> {

public NamingSystemIdentifierType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	NamingSystemIdentifierType enm = FhirFactory.eINSTANCE.createNamingSystemIdentifierType();
	String s = p.getValueAsString();
	enm.setValue(NamingSystemIdentifierTypeEnum.getByName(s));
	return enm;
	}
}
