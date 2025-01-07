package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.VisionEyes;
import org.hl7.fhir.VisionEyesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class VisionEyesDeserializer extends JsonDeserializer<VisionEyes> {

public VisionEyes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	VisionEyes enm = FhirFactory.eINSTANCE.createVisionEyes();
	String s = p.getValueAsString();
	enm.setValue(VisionEyesEnum.getByName(s));
	return enm;
	}
}
