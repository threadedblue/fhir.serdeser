package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ImagingStudyStatus;
import org.hl7.fhir.ImagingStudyStatusEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ImagingStudyStatusDeserializer extends JsonDeserializer<ImagingStudyStatus> {

public ImagingStudyStatus deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ImagingStudyStatus enm = FhirFactory.eINSTANCE.createImagingStudyStatus();
	String s = p.getValueAsString();
	enm.setValue(ImagingStudyStatusEnum.getByName(s));
	return enm;
	}
}
