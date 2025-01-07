package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AddressType;
import org.hl7.fhir.AddressTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AddressTypeDeserializer extends JsonDeserializer<AddressType> {

public AddressType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AddressType enm = FhirFactory.eINSTANCE.createAddressType();
	String s = p.getValueAsString();
	enm.setValue(AddressTypeEnum.getByName(s));
	return enm;
	}
}
