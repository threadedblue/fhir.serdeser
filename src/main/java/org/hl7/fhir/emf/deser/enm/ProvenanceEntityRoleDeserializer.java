package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ProvenanceEntityRole;
import org.hl7.fhir.ProvenanceEntityRoleEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ProvenanceEntityRoleDeserializer extends JsonDeserializer<ProvenanceEntityRole> {

public ProvenanceEntityRole deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ProvenanceEntityRole enm = FhirFactory.eINSTANCE.createProvenanceEntityRole();
	String s = p.getValueAsString();
	enm.setValue(ProvenanceEntityRoleEnum.getByName(s));
	return enm;
	}
}
