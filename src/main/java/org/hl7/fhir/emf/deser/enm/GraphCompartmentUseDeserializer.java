package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.GraphCompartmentUse;
import org.hl7.fhir.GraphCompartmentUseEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class GraphCompartmentUseDeserializer extends JsonDeserializer<GraphCompartmentUse> {

public GraphCompartmentUse deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	GraphCompartmentUse enm = FhirFactory.eINSTANCE.createGraphCompartmentUse();
	String s = p.getValueAsString();
	enm.setValue(GraphCompartmentUseEnum.getByName(s));
	return enm;
	}
}
