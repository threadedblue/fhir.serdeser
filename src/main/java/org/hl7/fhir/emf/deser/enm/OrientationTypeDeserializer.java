package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.OrientationType;
import org.hl7.fhir.OrientationTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class OrientationTypeDeserializer extends JsonDeserializer<OrientationType> {

public OrientationType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	OrientationType enm = FhirFactory.eINSTANCE.createOrientationType();
	String s = p.getValueAsString();
	enm.setValue(OrientationTypeEnum.getByName(s));
	return enm;
	}
}
