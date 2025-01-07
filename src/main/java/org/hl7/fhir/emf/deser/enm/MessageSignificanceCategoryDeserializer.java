package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.MessageSignificanceCategory;
import org.hl7.fhir.MessageSignificanceCategoryEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MessageSignificanceCategoryDeserializer extends JsonDeserializer<MessageSignificanceCategory> {

public MessageSignificanceCategory deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	MessageSignificanceCategory enm = FhirFactory.eINSTANCE.createMessageSignificanceCategory();
	String s = p.getValueAsString();
	enm.setValue(MessageSignificanceCategoryEnum.getByName(s));
	return enm;
	}
}
