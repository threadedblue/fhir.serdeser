package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FHIRDefinedType;
import org.hl7.fhir.FHIRDefinedTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FHIRDefinedTypeDeserializer extends JsonDeserializer<FHIRDefinedType> {

public FHIRDefinedType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	FHIRDefinedType enm = FhirFactory.eINSTANCE.createFHIRDefinedType();
	String s = p.getValueAsString();
	enm.setValue(FHIRDefinedTypeEnum.getByName(s));
	return enm;
	}
}
