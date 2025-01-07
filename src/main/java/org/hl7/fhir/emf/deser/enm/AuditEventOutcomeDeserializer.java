package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AuditEventOutcome;
import org.hl7.fhir.AuditEventOutcomeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AuditEventOutcomeDeserializer extends JsonDeserializer<AuditEventOutcome> {

public AuditEventOutcome deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AuditEventOutcome enm = FhirFactory.eINSTANCE.createAuditEventOutcome();
	String s = p.getValueAsString();
	enm.setValue(AuditEventOutcomeEnum.getByName(s));
	return enm;
	}
}
