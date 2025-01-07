package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ObservationDataType;
import org.hl7.fhir.ObservationDataTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ObservationDataTypeDeserializer extends JsonDeserializer<ObservationDataType> {

public ObservationDataType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ObservationDataType enm = FhirFactory.eINSTANCE.createObservationDataType();
	String s = p.getValueAsString();
	enm.setValue(ObservationDataTypeEnum.getByName(s));
	return enm;
	}
}
