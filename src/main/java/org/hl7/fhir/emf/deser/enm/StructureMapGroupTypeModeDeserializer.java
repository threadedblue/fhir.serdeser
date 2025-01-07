package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StructureMapGroupTypeMode;
import org.hl7.fhir.StructureMapGroupTypeModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StructureMapGroupTypeModeDeserializer extends JsonDeserializer<StructureMapGroupTypeMode> {

public StructureMapGroupTypeMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StructureMapGroupTypeMode enm = FhirFactory.eINSTANCE.createStructureMapGroupTypeMode();
	String s = p.getValueAsString();
	enm.setValue(StructureMapGroupTypeModeEnum.getByName(s));
	return enm;
	}
}
