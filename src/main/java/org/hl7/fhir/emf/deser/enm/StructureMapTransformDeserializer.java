package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StructureMapTransform;
import org.hl7.fhir.StructureMapTransformEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StructureMapTransformDeserializer extends JsonDeserializer<StructureMapTransform> {

public StructureMapTransform deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StructureMapTransform enm = FhirFactory.eINSTANCE.createStructureMapTransform();
	String s = p.getValueAsString();
	enm.setValue(StructureMapTransformEnum.getByName(s));
	return enm;
	}
}
