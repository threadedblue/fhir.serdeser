package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CharacteristicCombination;
import org.hl7.fhir.CharacteristicCombinationEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CharacteristicCombinationDeserializer extends JsonDeserializer<CharacteristicCombination> {

public CharacteristicCombination deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CharacteristicCombination enm = FhirFactory.eINSTANCE.createCharacteristicCombination();
	String s = p.getValueAsString();
	enm.setValue(CharacteristicCombinationEnum.getByName(s));
	return enm;
	}
}
