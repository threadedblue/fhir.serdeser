package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ConsentState;
import org.hl7.fhir.ConsentStateEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConsentStateDeserializer extends JsonDeserializer<ConsentState> {

public ConsentState deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ConsentState enm = FhirFactory.eINSTANCE.createConsentState();
	String s = p.getValueAsString();
	enm.setValue(ConsentStateEnum.getByName(s));
	return enm;
	}
}
