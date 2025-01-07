package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.BiologicallyDerivedProductStatus;
import org.hl7.fhir.BiologicallyDerivedProductStatusEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BiologicallyDerivedProductStatusDeserializer extends JsonDeserializer<BiologicallyDerivedProductStatus> {

public BiologicallyDerivedProductStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	BiologicallyDerivedProductStatus enm = FhirFactory.eINSTANCE.createBiologicallyDerivedProductStatus();
	String s = p.getValueAsString();
	enm.setValue(BiologicallyDerivedProductStatusEnum.getByName(s));
	return enm;
	}
}
