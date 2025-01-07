package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.PropertyRepresentation;
import org.hl7.fhir.PropertyRepresentationEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PropertyRepresentationDeserializer extends JsonDeserializer<PropertyRepresentation> {

public PropertyRepresentation deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	PropertyRepresentation enm = FhirFactory.eINSTANCE.createPropertyRepresentation();
	String s = p.getValueAsString();
	enm.setValue(PropertyRepresentationEnum.getByName(s));
	return enm;
	}
}
