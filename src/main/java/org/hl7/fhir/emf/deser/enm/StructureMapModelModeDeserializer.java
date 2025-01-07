package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StructureMapModelMode;
import org.hl7.fhir.StructureMapModelModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StructureMapModelModeDeserializer extends JsonDeserializer<StructureMapModelMode> {

public StructureMapModelMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StructureMapModelMode enm = FhirFactory.eINSTANCE.createStructureMapModelMode();
	String s = p.getValueAsString();
	enm.setValue(StructureMapModelModeEnum.getByName(s));
	return enm;
	}
}
