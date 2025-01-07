package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.BiologicallyDerivedProductStorageScale;
import org.hl7.fhir.BiologicallyDerivedProductStorageScaleEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BiologicallyDerivedProductStorageScaleDeserializer extends JsonDeserializer<BiologicallyDerivedProductStorageScale> {

public BiologicallyDerivedProductStorageScale deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	BiologicallyDerivedProductStorageScale enm = FhirFactory.eINSTANCE.createBiologicallyDerivedProductStorageScale();
	String s = p.getValueAsString();
	enm.setValue(BiologicallyDerivedProductStorageScaleEnum.getByName(s));
	return enm;
	}
}
