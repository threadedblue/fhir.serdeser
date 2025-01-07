package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.GuideParameterCode;
import org.hl7.fhir.GuideParameterCodeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class GuideParameterCodeDeserializer extends JsonDeserializer<GuideParameterCode> {

public GuideParameterCode deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	GuideParameterCode enm = FhirFactory.eINSTANCE.createGuideParameterCode();
	String s = p.getValueAsString();
	enm.setValue(GuideParameterCodeEnum.getByName(s));
	return enm;
	}
}
