package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ClinicalUseDefinitionType;
import org.hl7.fhir.ClinicalUseDefinitionTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ClinicalUseDefinitionTypeDeserializer extends JsonDeserializer<ClinicalUseDefinitionType> {

public ClinicalUseDefinitionType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ClinicalUseDefinitionType enm = FhirFactory.eINSTANCE.createClinicalUseDefinitionType();
	String s = p.getValueAsString();
	enm.setValue(ClinicalUseDefinitionTypeEnum.getByName(s));
	return enm;
	}
}
