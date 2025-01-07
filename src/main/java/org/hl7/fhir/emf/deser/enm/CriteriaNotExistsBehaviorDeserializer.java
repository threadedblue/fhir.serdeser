package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CriteriaNotExistsBehavior;
import org.hl7.fhir.CriteriaNotExistsBehaviorEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CriteriaNotExistsBehaviorDeserializer extends JsonDeserializer<CriteriaNotExistsBehavior> {

public CriteriaNotExistsBehavior deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CriteriaNotExistsBehavior enm = FhirFactory.eINSTANCE.createCriteriaNotExistsBehavior();
	String s = p.getValueAsString();
	enm.setValue(CriteriaNotExistsBehaviorEnum.getByName(s));
	return enm;
	}
}
