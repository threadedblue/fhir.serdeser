package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.NoteType;
import org.hl7.fhir.NoteTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class NoteTypeDeserializer extends JsonDeserializer<NoteType> {

public NoteType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	NoteType enm = FhirFactory.eINSTANCE.createNoteType();
	String s = p.getValueAsString();
	enm.setValue(NoteTypeEnum.getByName(s));
	return enm;
	}
}
