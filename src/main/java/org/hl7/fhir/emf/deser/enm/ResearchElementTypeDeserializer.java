package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ResearchElementType;
import org.hl7.fhir.ResearchElementTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ResearchElementTypeDeserializer extends JsonDeserializer<ResearchElementType> {

public ResearchElementType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ResearchElementType enm = FhirFactory.eINSTANCE.createResearchElementType();
	String s = p.getValueAsString();
	enm.setValue(ResearchElementTypeEnum.getByName(s));
	return enm;
	}
}
