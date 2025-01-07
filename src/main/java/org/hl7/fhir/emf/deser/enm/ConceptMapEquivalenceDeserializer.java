package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ConceptMapEquivalence;
import org.hl7.fhir.ConceptMapEquivalenceEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConceptMapEquivalenceDeserializer extends JsonDeserializer<ConceptMapEquivalence> {

public ConceptMapEquivalence deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ConceptMapEquivalence enm = FhirFactory.eINSTANCE.createConceptMapEquivalence();
	String s = p.getValueAsString();
	enm.setValue(ConceptMapEquivalenceEnum.getByName(s));
	return enm;
	}
}
