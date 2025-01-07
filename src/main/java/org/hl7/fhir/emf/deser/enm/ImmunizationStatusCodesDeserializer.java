package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ImmunizationStatusCodes;
import org.hl7.fhir.ImmunizationStatusCodesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ImmunizationStatusCodesDeserializer extends JsonDeserializer<ImmunizationStatusCodes> {

public ImmunizationStatusCodes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ImmunizationStatusCodes enm = FhirFactory.eINSTANCE.createImmunizationStatusCodes();
	String s = p.getValueAsString();
	enm.setValue(ImmunizationStatusCodesEnum.getByName(s));
	return enm;
	}
}
