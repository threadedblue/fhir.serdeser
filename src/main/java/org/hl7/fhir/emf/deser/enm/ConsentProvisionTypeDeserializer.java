package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ConsentProvisionType;
import org.hl7.fhir.ConsentProvisionTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ConsentProvisionTypeDeserializer extends JsonDeserializer<ConsentProvisionType> {

public ConsentProvisionType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ConsentProvisionType enm = FhirFactory.eINSTANCE.createConsentProvisionType();
	String s = p.getValueAsString();
	enm.setValue(ConsentProvisionTypeEnum.getByName(s));
	return enm;
	}
}
