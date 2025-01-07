package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.GuidePageGeneration;
import org.hl7.fhir.GuidePageGenerationEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class GuidePageGenerationDeserializer extends JsonDeserializer<GuidePageGeneration> {

public GuidePageGeneration deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	GuidePageGeneration enm = FhirFactory.eINSTANCE.createGuidePageGeneration();
	String s = p.getValueAsString();
	enm.setValue(GuidePageGenerationEnum.getByName(s));
	return enm;
	}
}
