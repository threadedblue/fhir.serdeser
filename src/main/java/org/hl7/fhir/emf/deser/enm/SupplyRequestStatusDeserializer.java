package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SupplyRequestStatus;
import org.hl7.fhir.SupplyRequestStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SupplyRequestStatusDeserializer extends JsonDeserializer<SupplyRequestStatus> {

public SupplyRequestStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SupplyRequestStatus enm = FhirFactory.eINSTANCE.createSupplyRequestStatus();
	String s = p.getValueAsString();
	enm.setValue(SupplyRequestStatusEnum.getByName(s));
	return enm;
	}
}
