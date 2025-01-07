package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.FinancialResourceStatusCodes;
import org.hl7.fhir.FinancialResourceStatusCodesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FinancialResourceStatusCodesDeserializer extends JsonDeserializer<FinancialResourceStatusCodes> {

public FinancialResourceStatusCodes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	FinancialResourceStatusCodes enm = FhirFactory.eINSTANCE.createFinancialResourceStatusCodes();
	String s = p.getValueAsString();
	enm.setValue(FinancialResourceStatusCodesEnum.getByName(s));
	return enm;
	}
}
