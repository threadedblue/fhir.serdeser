package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SupplyDeliveryStatus;
import org.hl7.fhir.SupplyDeliveryStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SupplyDeliveryStatusDeserializer extends JsonDeserializer<SupplyDeliveryStatus> {

public SupplyDeliveryStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SupplyDeliveryStatus enm = FhirFactory.eINSTANCE.createSupplyDeliveryStatus();
	String s = p.getValueAsString();
	enm.setValue(SupplyDeliveryStatusEnum.getByName(s));
	return enm;
	}
}
