package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ActionParticipantType;
import org.hl7.fhir.ActionParticipantTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ActionParticipantTypeDeserializer extends JsonDeserializer<ActionParticipantType> {

public ActionParticipantType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ActionParticipantType enm = FhirFactory.eINSTANCE.createActionParticipantType();
	String s = p.getValueAsString();
	enm.setValue(ActionParticipantTypeEnum.getByName(s));
	return enm;
	}
}
