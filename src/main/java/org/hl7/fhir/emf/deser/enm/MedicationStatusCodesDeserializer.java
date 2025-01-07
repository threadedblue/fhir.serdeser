package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.MedicationStatusCodes;
import org.hl7.fhir.MedicationStatusCodesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MedicationStatusCodesDeserializer extends JsonDeserializer<MedicationStatusCodes> {

public MedicationStatusCodes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	MedicationStatusCodes enm = FhirFactory.eINSTANCE.createMedicationStatusCodes();
	String s = p.getValueAsString();
	enm.setValue(MedicationStatusCodesEnum.getByName(s));
	return enm;
	}
}
