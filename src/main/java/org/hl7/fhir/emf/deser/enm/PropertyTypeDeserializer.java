package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.PropertyType;
import org.hl7.fhir.PropertyTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PropertyTypeDeserializer extends JsonDeserializer<PropertyType> {

public PropertyType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	PropertyType enm = FhirFactory.eINSTANCE.createPropertyType();
	String s = p.getValueAsString();
	enm.setValue(PropertyTypeEnum.getByName(s));
	return enm;
	}
}
