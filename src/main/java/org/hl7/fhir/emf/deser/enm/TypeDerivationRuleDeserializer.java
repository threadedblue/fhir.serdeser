package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.TypeDerivationRule;
import org.hl7.fhir.TypeDerivationRuleEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TypeDerivationRuleDeserializer extends JsonDeserializer<TypeDerivationRule> {

public TypeDerivationRule deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	TypeDerivationRule enm = FhirFactory.eINSTANCE.createTypeDerivationRule();
	String s = p.getValueAsString();
	enm.setValue(TypeDerivationRuleEnum.getByName(s));
	return enm;
	}
}
