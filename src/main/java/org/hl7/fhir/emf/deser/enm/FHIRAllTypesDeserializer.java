package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FHIRAllTypes;
import org.hl7.fhir.FHIRAllTypesEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FHIRAllTypesDeserializer extends JsonDeserializer<FHIRAllTypes> {

public FHIRAllTypes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	FHIRAllTypes enm = FhirFactory.eINSTANCE.createFHIRAllTypes();
	String s = p.getValueAsString();
	enm.setValue(FHIRAllTypesEnum.getByName(s));
	return enm;
	}
}
