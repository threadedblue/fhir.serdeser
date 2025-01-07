package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SubscriptionNotificationType;
import org.hl7.fhir.SubscriptionNotificationTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SubscriptionNotificationTypeDeserializer extends JsonDeserializer<SubscriptionNotificationType> {

public SubscriptionNotificationType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SubscriptionNotificationType enm = FhirFactory.eINSTANCE.createSubscriptionNotificationType();
	String s = p.getValueAsString();
	enm.setValue(SubscriptionNotificationTypeEnum.getByName(s));
	return enm;
	}
}
