package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.LocationMode;
import org.hl7.fhir.LocationModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocationModeDeserializer extends JsonDeserializer<LocationMode> {

public LocationMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	LocationMode enm = FhirFactory.eINSTANCE.createLocationMode();
	String s = p.getValueAsString();
	enm.setValue(LocationModeEnum.getByName(s));
	return enm;
	}
}
