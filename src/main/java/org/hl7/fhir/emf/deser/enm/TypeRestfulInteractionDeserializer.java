package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TypeRestfulInteraction;
import org.hl7.fhir.TypeRestfulInteractionEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TypeRestfulInteractionDeserializer extends JsonDeserializer<TypeRestfulInteraction> {

public TypeRestfulInteraction deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TypeRestfulInteraction enm = FhirFactory.eINSTANCE.createTypeRestfulInteraction();
	String s = p.getValueAsString();
	enm.setValue(TypeRestfulInteractionEnum.getByName(s));
	return enm;
	}
}
