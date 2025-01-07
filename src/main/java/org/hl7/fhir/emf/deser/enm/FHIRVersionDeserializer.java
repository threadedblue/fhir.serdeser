package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FHIRVersion;
import org.hl7.fhir.FHIRVersionEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FHIRVersionDeserializer extends JsonDeserializer<FHIRVersion> {

public FHIRVersion deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	FHIRVersion enm = FhirFactory.eINSTANCE.createFHIRVersion();
	String s = p.getValueAsString();
	enm.setValue(FHIRVersionEnum.getByName(s));
	return enm;
	}
}
