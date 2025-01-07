package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.MessageheaderResponseRequest;
import org.hl7.fhir.MessageheaderResponseRequestEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MessageheaderResponseRequestDeserializer extends JsonDeserializer<MessageheaderResponseRequest> {

public MessageheaderResponseRequest deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	MessageheaderResponseRequest enm = FhirFactory.eINSTANCE.createMessageheaderResponseRequest();
	String s = p.getValueAsString();
	enm.setValue(MessageheaderResponseRequestEnum.getByName(s));
	return enm;
	}
}
