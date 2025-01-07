package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.LocationStatus;
import org.hl7.fhir.LocationStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocationStatusDeserializer extends JsonDeserializer<LocationStatus> {

public LocationStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	LocationStatus enm = FhirFactory.eINSTANCE.createLocationStatus();
	String s = p.getValueAsString();
	enm.setValue(LocationStatusEnum.getByName(s));
	return enm;
	}
}
