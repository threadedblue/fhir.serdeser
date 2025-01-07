package org.hl7.fhir.emf.deser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ResourceContainer;
import org.hl7.fhir.emf.FHIRSDS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ResourceContainerDeserializer extends JsonDeserializer<ResourceContainer> {
	private static final Logger LOG = LoggerFactory.getLogger(ResourceContainerDeserializer.class);
	
	@Override
	public ResourceContainer deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
			p.nextToken();
		}
		
		JsonNode dataNode = p.readValueAs(JsonNode.class);
		
		EObject eObject = FHIRSDS.loadJSON(dataNode);
		java.lang.String s = dataNode.get("resourceType").textValue();
		LOG.trace("beClass=" + s);
		Class<?> clazz = FHIRSDS.classFromName(s);
		ResourceContainer resourceContainer = FhirFactory.eINSTANCE.createResourceContainer();
		Method method;
		try {
			method = resourceContainer.getClass().getDeclaredMethod(java.lang.String.format("set%s", s),
					clazz);
			method.setAccessible(true);
			method.invoke(resourceContainer, eObject);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return resourceContainer;
	}
}
