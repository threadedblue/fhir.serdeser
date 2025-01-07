package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.XPathUsageType;
import org.hl7.fhir.XPathUsageTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class XPathUsageTypeDeserializer extends JsonDeserializer<XPathUsageType> {

public XPathUsageType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	XPathUsageType enm = FhirFactory.eINSTANCE.createXPathUsageType();
	String s = p.getValueAsString();
	enm.setValue(XPathUsageTypeEnum.getByName(s));
	return enm;
	}
}
