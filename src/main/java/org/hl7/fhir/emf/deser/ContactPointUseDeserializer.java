package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.hl7.fhir.ContactPointUse;
import org.hl7.fhir.ContactPointUseEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ContactPointUseDeserializer extends JsonDeserializer<ContactPointUse> {

	@Override
	public ContactPointUse deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
	    if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
	      p.nextToken();
	    }

	    ContactPointUse enm = FhirFactory.eINSTANCE.createContactPointUse();
		String s = p.getValueAsString();
		enm.setValue(ContactPointUseEnum.getByName(s));
	    return enm;
	}
}
