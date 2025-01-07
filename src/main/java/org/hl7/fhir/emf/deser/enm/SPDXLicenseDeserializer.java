package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SPDXLicense;
import org.hl7.fhir.SPDXLicenseEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SPDXLicenseDeserializer extends JsonDeserializer<SPDXLicense> {

public SPDXLicense deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SPDXLicense enm = FhirFactory.eINSTANCE.createSPDXLicense();
	String s = p.getValueAsString();
	enm.setValue(SPDXLicenseEnum.getByName(s));
	return enm;
	}
}
