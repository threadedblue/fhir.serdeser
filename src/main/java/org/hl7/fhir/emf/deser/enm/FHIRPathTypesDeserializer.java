package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FHIRPathTypes;
import org.hl7.fhir.FHIRPathTypesEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FHIRPathTypesDeserializer extends JsonDeserializer<FHIRPathTypes> {

public FHIRPathTypes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	FHIRPathTypes enm = FhirFactory.eINSTANCE.createFHIRPathTypes();
	String s = p.getValueAsString();
	enm.setValue(FHIRPathTypesEnum.getByName(s));
	return enm;
	}
}
