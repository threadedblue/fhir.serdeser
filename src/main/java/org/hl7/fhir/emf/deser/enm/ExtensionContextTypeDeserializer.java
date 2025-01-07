package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ExtensionContextType;
import org.hl7.fhir.ExtensionContextTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ExtensionContextTypeDeserializer extends JsonDeserializer<ExtensionContextType> {

public ExtensionContextType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ExtensionContextType enm = FhirFactory.eINSTANCE.createExtensionContextType();
	String s = p.getValueAsString();
	enm.setValue(ExtensionContextTypeEnum.getByName(s));
	return enm;
	}
}
