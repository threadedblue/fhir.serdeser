package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.InvoicePriceComponentType;
import org.hl7.fhir.InvoicePriceComponentTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class InvoicePriceComponentTypeDeserializer extends JsonDeserializer<InvoicePriceComponentType> {

public InvoicePriceComponentType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	InvoicePriceComponentType enm = FhirFactory.eINSTANCE.createInvoicePriceComponentType();
	String s = p.getValueAsString();
	enm.setValue(InvoicePriceComponentTypeEnum.getByName(s));
	return enm;
	}
}
