package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ConsentDataMeaning;
import org.hl7.fhir.ConsentDataMeaningEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConsentDataMeaningDeserializer extends JsonDeserializer<ConsentDataMeaning> {

public ConsentDataMeaning deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ConsentDataMeaning enm = FhirFactory.eINSTANCE.createConsentDataMeaning();
	String s = p.getValueAsString();
	enm.setValue(ConsentDataMeaningEnum.getByName(s));
	return enm;
	}
}
