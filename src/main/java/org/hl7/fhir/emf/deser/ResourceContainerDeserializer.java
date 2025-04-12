package org.hl7.fhir.emf.deser;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.ResourceContainer;
import org.hl7.fhir.emf.FHIRSerDeser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ResourceContainerDeserializer extends JsonDeserializer<ResourceContainer> {
	private static final Logger log = LoggerFactory.getLogger(ResourceContainerDeserializer.class);
	
	@Override
	public ResourceContainer deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		if (p.getCurrentToken() == JsonToken.FIELD_NAME) {
			p.nextToken();
		}
		
		JsonNode dataNode = p.readValueAs(JsonNode.class);
		
		EObject eObject = FHIRSerDeser.loadJSON(dataNode);
		java.lang.String s = dataNode.get("resourceType").textValue();
		log.debug("beClass=" + s);
		ResourceContainer resourceContainer = FhirFactory.eINSTANCE.createResourceContainer();
		// Class<?> clazz = FHIRSerDeser.classFromName(s);
		// Method method;
		// try {
		// 	method = resourceContainer.getClass().getDeclaredMethod(java.lang.String.format("set%s", s),
		// 			clazz);
		// 	method.setAccessible(true);
		// 	method.invoke(resourceContainer, eObject);
		// } catch (NoSuchMethodException e) {
		// 	e.printStackTrace();
		// } catch (SecurityException e) {
		// 	e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// 	e.printStackTrace();
		// } catch (IllegalArgumentException e) {
		// 	e.printStackTrace();
		// } catch (InvocationTargetException e) {
		// 	e.printStackTrace();
		// }
		// for (EStructuralFeature feature : resourceContainer.eClass().getEAllStructuralFeatures()) {
		// 	log.debug("befeature=" + feature.getName());
		// 	if (feature instanceof EReference) {
		// 		if (feature.getName().equalsIgnoreCase(s)) {
		// 			resourceContainer.eSet(feature, eObject);
		// 			break;
		// 		}
		// 	}
		// }
		log.debug("beresourceContainer=" + (EObjectContainmentEList)resourceContainer.eClass().getEStructuralFeature(s));
		return resourceContainer;
	}
}
