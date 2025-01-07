package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CompositionAttestationMode;
import org.hl7.fhir.CompositionAttestationModeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CompositionAttestationModeDeserializer extends JsonDeserializer<CompositionAttestationMode> {

public CompositionAttestationMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CompositionAttestationMode enm = FhirFactory.eINSTANCE.createCompositionAttestationMode();
	String s = p.getValueAsString();
	enm.setValue(CompositionAttestationModeEnum.getByName(s));
	return enm;
	}
}
