package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SlotStatus;
import org.hl7.fhir.SlotStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SlotStatusDeserializer extends JsonDeserializer<SlotStatus> {

public SlotStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SlotStatus enm = FhirFactory.eINSTANCE.createSlotStatus();
	String s = p.getValueAsString();
	enm.setValue(SlotStatusEnum.getByName(s));
	return enm;
	}
}
