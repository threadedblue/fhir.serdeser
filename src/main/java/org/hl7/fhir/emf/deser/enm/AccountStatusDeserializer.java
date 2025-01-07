package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AccountStatus;
import org.hl7.fhir.AccountStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AccountStatusDeserializer extends JsonDeserializer<AccountStatus> {

public AccountStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AccountStatus enm = FhirFactory.eINSTANCE.createAccountStatus();
	String s = p.getValueAsString();
	enm.setValue(AccountStatusEnum.getByName(s));
	return enm;
	}
}
