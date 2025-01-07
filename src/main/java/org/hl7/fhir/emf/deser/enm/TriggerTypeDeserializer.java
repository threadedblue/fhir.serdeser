package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TriggerType;
import org.hl7.fhir.TriggerTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TriggerTypeDeserializer extends JsonDeserializer<TriggerType> {

public TriggerType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TriggerType enm = FhirFactory.eINSTANCE.createTriggerType();
	String s = p.getValueAsString();
	enm.setValue(TriggerTypeEnum.getByName(s));
	return enm;
	}
}
