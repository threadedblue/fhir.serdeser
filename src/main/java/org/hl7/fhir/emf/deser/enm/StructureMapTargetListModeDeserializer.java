package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StructureMapTargetListMode;
import org.hl7.fhir.StructureMapTargetListModeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StructureMapTargetListModeDeserializer extends JsonDeserializer<StructureMapTargetListMode> {

public StructureMapTargetListMode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StructureMapTargetListMode enm = FhirFactory.eINSTANCE.createStructureMapTargetListMode();
	String s = p.getValueAsString();
	enm.setValue(StructureMapTargetListModeEnum.getByName(s));
	return enm;
	}
}
