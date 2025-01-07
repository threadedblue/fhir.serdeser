package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.LinkageType;
import org.hl7.fhir.LinkageTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LinkageTypeDeserializer extends JsonDeserializer<LinkageType> {

public LinkageType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	LinkageType enm = FhirFactory.eINSTANCE.createLinkageType();
	String s = p.getValueAsString();
	enm.setValue(LinkageTypeEnum.getByName(s));
	return enm;
	}
}
