package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StructureMapInputMode;
import org.hl7.fhir.StructureMapInputModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StructureMapInputModeDeserializer extends JsonDeserializer<StructureMapInputMode> {

public StructureMapInputMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StructureMapInputMode enm = FhirFactory.eINSTANCE.createStructureMapInputMode();
	String s = p.getValueAsString();
	enm.setValue(StructureMapInputModeEnum.getByName(s));
	return enm;
	}
}
