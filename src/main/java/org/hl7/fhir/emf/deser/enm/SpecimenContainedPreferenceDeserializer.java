package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.SpecimenContainedPreference;
import org.hl7.fhir.SpecimenContainedPreferenceEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SpecimenContainedPreferenceDeserializer extends JsonDeserializer<SpecimenContainedPreference> {

public SpecimenContainedPreference deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	SpecimenContainedPreference enm = FhirFactory.eINSTANCE.createSpecimenContainedPreference();
	String s = p.getValueAsString();
	enm.setValue(SpecimenContainedPreferenceEnum.getByName(s));
	return enm;
	}
}
