package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.IdentifierUse;
import org.hl7.fhir.IdentifierUseEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IdentifierUseDeserializer extends JsonDeserializer<IdentifierUse> {

public IdentifierUse deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	IdentifierUse enm = FhirFactory.eINSTANCE.createIdentifierUse();
	String s = p.getValueAsString();
	enm.setValue(IdentifierUseEnum.getByName(s));
	return enm;
	}
}
