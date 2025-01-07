package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.AdverseEventActuality;
import org.hl7.fhir.AdverseEventActualityEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class AdverseEventActualityDeserializer extends JsonDeserializer<AdverseEventActuality> {

public AdverseEventActuality deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	AdverseEventActuality enm = FhirFactory.eINSTANCE.createAdverseEventActuality();
	String s = p.getValueAsString();
	enm.setValue(AdverseEventActualityEnum.getByName(s));
	return enm;
	}
}
