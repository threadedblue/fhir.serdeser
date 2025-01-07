package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.GroupMeasure;
import org.hl7.fhir.GroupMeasureEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class GroupMeasureDeserializer extends JsonDeserializer<GroupMeasure> {

public GroupMeasure deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	GroupMeasure enm = FhirFactory.eINSTANCE.createGroupMeasure();
	String s = p.getValueAsString();
	enm.setValue(GroupMeasureEnum.getByName(s));
	return enm;
	}
}
