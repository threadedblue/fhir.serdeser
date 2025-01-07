package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.MedicationStatementStatusCodes;
import org.hl7.fhir.MedicationStatementStatusCodesEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MedicationStatementStatusCodesDeserializer extends JsonDeserializer<MedicationStatementStatusCodes> {

public MedicationStatementStatusCodes deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	MedicationStatementStatusCodes enm = FhirFactory.eINSTANCE.createMedicationStatementStatusCodes();
	String s = p.getValueAsString();
	enm.setValue(MedicationStatementStatusCodesEnum.getByName(s));
	return enm;
	}
}
