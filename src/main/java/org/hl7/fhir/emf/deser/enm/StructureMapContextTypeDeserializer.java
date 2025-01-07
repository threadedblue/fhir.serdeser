package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StructureMapContextType;
import org.hl7.fhir.StructureMapContextTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StructureMapContextTypeDeserializer extends JsonDeserializer<StructureMapContextType> {

public StructureMapContextType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StructureMapContextType enm = FhirFactory.eINSTANCE.createStructureMapContextType();
	String s = p.getValueAsString();
	enm.setValue(StructureMapContextTypeEnum.getByName(s));
	return enm;
	}
}
