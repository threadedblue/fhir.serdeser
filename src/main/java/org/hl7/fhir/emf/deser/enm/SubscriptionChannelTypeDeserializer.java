package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SubscriptionChannelType;
import org.hl7.fhir.SubscriptionChannelTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SubscriptionChannelTypeDeserializer extends JsonDeserializer<SubscriptionChannelType> {

public SubscriptionChannelType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SubscriptionChannelType enm = FhirFactory.eINSTANCE.createSubscriptionChannelType();
	String s = p.getValueAsString();
	enm.setValue(SubscriptionChannelTypeEnum.getByName(s));
	return enm;
	}
}
