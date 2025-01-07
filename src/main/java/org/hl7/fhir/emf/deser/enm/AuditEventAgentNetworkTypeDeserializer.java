package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AuditEventAgentNetworkType;
import org.hl7.fhir.AuditEventAgentNetworkTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AuditEventAgentNetworkTypeDeserializer extends JsonDeserializer<AuditEventAgentNetworkType> {

public AuditEventAgentNetworkType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AuditEventAgentNetworkType enm = FhirFactory.eINSTANCE.createAuditEventAgentNetworkType();
	String s = p.getValueAsString();
	enm.setValue(AuditEventAgentNetworkTypeEnum.getByName(s));
	return enm;
	}
}
