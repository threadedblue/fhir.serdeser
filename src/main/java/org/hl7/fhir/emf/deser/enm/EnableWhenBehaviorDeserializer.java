package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.EnableWhenBehavior;
import org.hl7.fhir.EnableWhenBehaviorEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EnableWhenBehaviorDeserializer extends JsonDeserializer<EnableWhenBehavior> {

public EnableWhenBehavior deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	EnableWhenBehavior enm = FhirFactory.eINSTANCE.createEnableWhenBehavior();
	String s = p.getValueAsString();
	enm.setValue(EnableWhenBehaviorEnum.getByName(s));
	return enm;
	}
}
