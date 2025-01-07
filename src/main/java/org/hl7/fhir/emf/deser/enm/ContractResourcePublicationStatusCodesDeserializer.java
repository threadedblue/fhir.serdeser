package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ContractResourcePublicationStatusCodes;
import org.hl7.fhir.ContractResourcePublicationStatusCodesEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ContractResourcePublicationStatusCodesDeserializer extends JsonDeserializer<ContractResourcePublicationStatusCodes> {

public ContractResourcePublicationStatusCodes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ContractResourcePublicationStatusCodes enm = FhirFactory.eINSTANCE.createContractResourcePublicationStatusCodes();
	String s = p.getValueAsString();
	enm.setValue(ContractResourcePublicationStatusCodesEnum.getByName(s));
	return enm;
	}
}
