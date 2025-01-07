package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.Use;
import org.hl7.fhir.UseEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class UseDeserializer extends JsonDeserializer<Use> {

public Use deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	Use enm = FhirFactory.eINSTANCE.createUse();
	String s = p.getValueAsString();
	enm.setValue(UseEnum.getByName(s));
	return enm;
	}
}
