package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.StrandType;
import org.hl7.fhir.StrandTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StrandTypeDeserializer extends JsonDeserializer<StrandType> {

public StrandType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	StrandType enm = FhirFactory.eINSTANCE.createStrandType();
	String s = p.getValueAsString();
	enm.setValue(StrandTypeEnum.getByName(s));
	return enm;
	}
}
