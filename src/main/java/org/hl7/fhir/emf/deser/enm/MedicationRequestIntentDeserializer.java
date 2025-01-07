package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.MedicationRequestIntent;
import org.hl7.fhir.MedicationRequestIntentEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MedicationRequestIntentDeserializer extends JsonDeserializer<MedicationRequestIntent> {

public MedicationRequestIntent deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	MedicationRequestIntent enm = FhirFactory.eINSTANCE.createMedicationRequestIntent();
	String s = p.getValueAsString();
	enm.setValue(MedicationRequestIntentEnum.getByName(s));
	return enm;
	}
}
