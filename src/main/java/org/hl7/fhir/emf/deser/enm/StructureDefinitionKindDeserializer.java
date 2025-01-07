package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StructureDefinitionKind;
import org.hl7.fhir.StructureDefinitionKindEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StructureDefinitionKindDeserializer extends JsonDeserializer<StructureDefinitionKind> {

public StructureDefinitionKind deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StructureDefinitionKind enm = FhirFactory.eINSTANCE.createStructureDefinitionKind();
	String s = p.getValueAsString();
	enm.setValue(StructureDefinitionKindEnum.getByName(s));
	return enm;
	}
}
