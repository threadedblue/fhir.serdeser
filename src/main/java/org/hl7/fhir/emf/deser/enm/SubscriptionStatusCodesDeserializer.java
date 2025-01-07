package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SubscriptionStatusCodes;
import org.hl7.fhir.SubscriptionStatusCodesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SubscriptionStatusCodesDeserializer extends JsonDeserializer<SubscriptionStatusCodes> {

public SubscriptionStatusCodes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SubscriptionStatusCodes enm = FhirFactory.eINSTANCE.createSubscriptionStatusCodes();
	String s = p.getValueAsString();
	enm.setValue(SubscriptionStatusCodesEnum.getByName(s));
	return enm;
	}
}
