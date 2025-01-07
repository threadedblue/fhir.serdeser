package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ActionRelationshipType;
import org.hl7.fhir.ActionRelationshipTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ActionRelationshipTypeDeserializer extends JsonDeserializer<ActionRelationshipType> {

public ActionRelationshipType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ActionRelationshipType enm = FhirFactory.eINSTANCE.createActionRelationshipType();
	String s = p.getValueAsString();
	enm.setValue(ActionRelationshipTypeEnum.getByName(s));
	return enm;
	}
}
