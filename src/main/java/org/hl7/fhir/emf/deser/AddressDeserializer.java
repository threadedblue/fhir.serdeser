package org.hl7.fhir.emf.deser;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.hl7.fhir.Address;
import org.hl7.fhir.FhirFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class AddressDeserializer extends JsonDeserializer<EList<Address>> {
	
	private static final Logger LOG = LoggerFactory.getLogger(AddressDeserializer.class);
	
	@Override
	public EList<Address> deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
			p.nextToken();
		}
		
		JsonNode dataNode = p.readValueAs(JsonNode.class);
		
		List<java.lang.String> line = dataNode.findValuesAsText("line");
		((ObjectNode)dataNode).remove("line");
		LOG.trace("beClass=" + line);
		EList<Address> eList = new BasicEList<Address>();
		Address address = FhirFactory.eINSTANCE.createAddress();
		eList.add(address);
		return eList;
	}
}
