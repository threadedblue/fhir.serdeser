package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EvidenceVariableHandling;
import org.hl7.fhir.EvidenceVariableHandlingEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EvidenceVariableHandlingDeserializer extends JsonDeserializer<EvidenceVariableHandling> {

public EvidenceVariableHandling deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EvidenceVariableHandling enm = FhirFactory.eINSTANCE.createEvidenceVariableHandling();
	String s = p.getValueAsString();
	enm.setValue(EvidenceVariableHandlingEnum.getByName(s));
	return enm;
	}
}
