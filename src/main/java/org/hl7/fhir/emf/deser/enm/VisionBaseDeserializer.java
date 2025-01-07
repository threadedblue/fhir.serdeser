package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.VisionBase;
import org.hl7.fhir.VisionBaseEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class VisionBaseDeserializer extends JsonDeserializer<VisionBase> {

public VisionBase deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	VisionBase enm = FhirFactory.eINSTANCE.createVisionBase();
	String s = p.getValueAsString();
	enm.setValue(VisionBaseEnum.getByName(s));
	return enm;
	}
}
