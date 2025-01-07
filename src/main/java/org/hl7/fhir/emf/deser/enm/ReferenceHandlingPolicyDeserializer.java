package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ReferenceHandlingPolicy;
import org.hl7.fhir.ReferenceHandlingPolicyEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ReferenceHandlingPolicyDeserializer extends JsonDeserializer<ReferenceHandlingPolicy> {

public ReferenceHandlingPolicy deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ReferenceHandlingPolicy enm = FhirFactory.eINSTANCE.createReferenceHandlingPolicy();
	String s = p.getValueAsString();
	enm.setValue(ReferenceHandlingPolicyEnum.getByName(s));
	return enm;
	}
}
