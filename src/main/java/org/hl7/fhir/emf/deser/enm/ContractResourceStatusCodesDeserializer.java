package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ContractResourceStatusCodes;
import org.hl7.fhir.ContractResourceStatusCodesEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ContractResourceStatusCodesDeserializer extends JsonDeserializer<ContractResourceStatusCodes> {

public ContractResourceStatusCodes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ContractResourceStatusCodes enm = FhirFactory.eINSTANCE.createContractResourceStatusCodes();
	String s = p.getValueAsString();
	enm.setValue(ContractResourceStatusCodesEnum.getByName(s));
	return enm;
	}
}
