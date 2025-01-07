package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.ContactPointSystem;
import org.hl7.fhir.ContactPointSystemEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ContactPointSystemDeserializer extends JsonDeserializer<ContactPointSystem> {

public ContactPointSystem deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	ContactPointSystem enm = FhirFactory.eINSTANCE.createContactPointSystem();
	String s = p.getValueAsString();
	enm.setValue(ContactPointSystemEnum.getByName(s));
	return enm;
	}
}
