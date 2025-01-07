package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.GraphCompartmentRule;
import org.hl7.fhir.GraphCompartmentRuleEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class GraphCompartmentRuleDeserializer extends JsonDeserializer<GraphCompartmentRule> {

public GraphCompartmentRule deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	GraphCompartmentRule enm = FhirFactory.eINSTANCE.createGraphCompartmentRule();
	String s = p.getValueAsString();
	enm.setValue(GraphCompartmentRuleEnum.getByName(s));
	return enm;
	}
}
