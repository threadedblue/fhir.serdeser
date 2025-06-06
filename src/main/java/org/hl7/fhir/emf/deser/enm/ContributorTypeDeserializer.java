package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ContributorType;
import org.hl7.fhir.ContributorTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ContributorTypeDeserializer extends JsonDeserializer<ContributorType> {

public ContributorType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ContributorType enm = FhirFactory.eINSTANCE.createContributorType();
	String s = p.getValueAsString();
	enm.setValue(ContributorTypeEnum.getByName(s));
	return enm;
	}
}
