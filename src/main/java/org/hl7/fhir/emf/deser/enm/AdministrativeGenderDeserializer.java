package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AdministrativeGender;
import org.hl7.fhir.AdministrativeGenderEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AdministrativeGenderDeserializer extends JsonDeserializer<AdministrativeGender> {

public AdministrativeGender deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AdministrativeGender enm = FhirFactory.eINSTANCE.createAdministrativeGender();
	String s = p.getValueAsString();
	enm.setValue(AdministrativeGenderEnum.getByName(s));
	return enm;
	}
}
