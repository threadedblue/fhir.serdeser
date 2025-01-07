package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.NameUse;
import org.hl7.fhir.NameUseEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NameUseDeserializer extends JsonDeserializer<NameUse> {

public NameUse deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	NameUse enm = FhirFactory.eINSTANCE.createNameUse();
	String s = p.getValueAsString();
	enm.setValue(NameUseEnum.getByName(s));
	return enm;
	}
}
