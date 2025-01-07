package org.hl7.fhir.emf.deser.enm;

import java.io.IOException;

import org.hl7.fhir.CatalogEntryRelationType;
import org.hl7.fhir.CatalogEntryRelationTypeEnum;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CatalogEntryRelationTypeDeserializer extends JsonDeserializer<CatalogEntryRelationType> {

public CatalogEntryRelationType deserialize(JsonParser p, DeserializationContext ctxt)
throws IOException, JsonProcessingException {

	CatalogEntryRelationType enm = FhirFactory.eINSTANCE.createCatalogEntryRelationType();
	String s = p.getValueAsString();
	enm.setValue(CatalogEntryRelationTypeEnum.getByName(s));
	return enm;
	}
}
