package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.BundleType;
import org.hl7.fhir.BundleTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BundleTypeDeserializer extends JsonDeserializer<BundleType> {

public BundleType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	BundleType enm = FhirFactory.eINSTANCE.createBundleType();
	String s = p.getValueAsString();
	enm.setValue(BundleTypeEnum.getByName(s));
	return enm;
	}
}
