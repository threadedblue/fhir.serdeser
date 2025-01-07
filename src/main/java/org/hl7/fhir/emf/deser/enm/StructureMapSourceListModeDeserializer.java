package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StructureMapSourceListMode;
import org.hl7.fhir.StructureMapSourceListModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StructureMapSourceListModeDeserializer extends JsonDeserializer<StructureMapSourceListMode> {

public StructureMapSourceListMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StructureMapSourceListMode enm = FhirFactory.eINSTANCE.createStructureMapSourceListMode();
	String s = p.getValueAsString();
	enm.setValue(StructureMapSourceListModeEnum.getByName(s));
	return enm;
	}
}
