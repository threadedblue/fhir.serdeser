package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.IdentityAssuranceLevel;
import org.hl7.fhir.IdentityAssuranceLevelEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IdentityAssuranceLevelDeserializer extends JsonDeserializer<IdentityAssuranceLevel> {

public IdentityAssuranceLevel deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	IdentityAssuranceLevel enm = FhirFactory.eINSTANCE.createIdentityAssuranceLevel();
	String s = p.getValueAsString();
	enm.setValue(IdentityAssuranceLevelEnum.getByName(s));
	return enm;
	}
}
