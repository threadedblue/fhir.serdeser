package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.UDIEntryType;
import org.hl7.fhir.UDIEntryTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class UDIEntryTypeDeserializer extends JsonDeserializer<UDIEntryType> {

public UDIEntryType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	UDIEntryType enm = FhirFactory.eINSTANCE.createUDIEntryType();
	String s = p.getValueAsString();
	enm.setValue(UDIEntryTypeEnum.getByName(s));
	return enm;
	}
}
