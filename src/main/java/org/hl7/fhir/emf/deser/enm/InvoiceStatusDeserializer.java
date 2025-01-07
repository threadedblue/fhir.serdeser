package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.InvoiceStatus;
import org.hl7.fhir.InvoiceStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class InvoiceStatusDeserializer extends JsonDeserializer<InvoiceStatus> {

public InvoiceStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	InvoiceStatus enm = FhirFactory.eINSTANCE.createInvoiceStatus();
	String s = p.getValueAsString();
	enm.setValue(InvoiceStatusEnum.getByName(s));
	return enm;
	}
}
