package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.RemittanceOutcome;
import org.hl7.fhir.RemittanceOutcomeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class RemittanceOutcomeDeserializer extends JsonDeserializer<RemittanceOutcome> {

public RemittanceOutcome deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	RemittanceOutcome enm = FhirFactory.eINSTANCE.createRemittanceOutcome();
	String s = p.getValueAsString();
	enm.setValue(RemittanceOutcomeEnum.getByName(s));
	return enm;
	}
}
