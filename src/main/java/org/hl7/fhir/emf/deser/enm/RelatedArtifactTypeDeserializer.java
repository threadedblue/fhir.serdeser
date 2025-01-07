package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.RelatedArtifactType;
import org.hl7.fhir.RelatedArtifactTypeEnum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class RelatedArtifactTypeDeserializer extends JsonDeserializer<RelatedArtifactType> {

public RelatedArtifactType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	RelatedArtifactType enm = FhirFactory.eINSTANCE.createRelatedArtifactType();
	String s = p.getValueAsString();
	enm.setValue(RelatedArtifactTypeEnum.getByName(s));
	return enm;
	}
}
