package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ConceptMapGroupUnmappedMode;
import org.hl7.fhir.ConceptMapGroupUnmappedModeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConceptMapGroupUnmappedModeDeserializer extends JsonDeserializer<ConceptMapGroupUnmappedMode> {

public ConceptMapGroupUnmappedMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ConceptMapGroupUnmappedMode enm = FhirFactory.eINSTANCE.createConceptMapGroupUnmappedMode();
	String s = p.getValueAsString();
	enm.setValue(ConceptMapGroupUnmappedModeEnum.getByName(s));
	return enm;
	}
}
