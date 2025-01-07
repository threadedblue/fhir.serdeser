package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.QualityType;
import org.hl7.fhir.QualityTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class QualityTypeDeserializer extends JsonDeserializer<QualityType> {

public QualityType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	QualityType enm = FhirFactory.eINSTANCE.createQualityType();
	String s = p.getValueAsString();
	enm.setValue(QualityTypeEnum.getByName(s));
	return enm;
	}
}
