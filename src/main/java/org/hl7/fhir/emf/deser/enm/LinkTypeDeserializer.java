package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.LinkType;
import org.hl7.fhir.LinkTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LinkTypeDeserializer extends JsonDeserializer<LinkType> {

public LinkType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	LinkType enm = FhirFactory.eINSTANCE.createLinkType();
	String s = p.getValueAsString();
	enm.setValue(LinkTypeEnum.getByName(s));
	return enm;
	}
}
