package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AuditEventAction;
import org.hl7.fhir.AuditEventActionEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AuditEventActionDeserializer extends JsonDeserializer<AuditEventAction> {

public AuditEventAction deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AuditEventAction enm = FhirFactory.eINSTANCE.createAuditEventAction();
	String s = p.getValueAsString();
	enm.setValue(AuditEventActionEnum.getByName(s));
	return enm;
	}
}
