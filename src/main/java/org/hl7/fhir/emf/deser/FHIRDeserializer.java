package org.hl7.fhir.emf.deser;

import java.io.IOException;
import java.util.function.Supplier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.property.EObjectFeatureProperty;
import org.emfjson.jackson.databind.property.EObjectProperty;
import org.emfjson.jackson.databind.property.EObjectPropertyMap;
import org.hl7.fhir.emf.FHIREObjectProperty;
import org.hl7.fhir.emf.FHIRIdentityInfo;
import org.hl7.fhir.emf.FHIRModule;
import org.hl7.fhir.emf.FHIRPropertyMapBuilder;
import org.hl7.fhir.emf.FHIRReferenceInfo;
import org.hl7.fhir.emf.FHIRTypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class FHIRDeserializer extends JsonDeserializer<EObject> {

    private static final Logger log = LoggerFactory.getLogger(FHIRDeserializer.class);

    private final FHIRIdentityInfo identityInfo;
    private final FHIRTypeInfo     typeInfo;
    private final FHIRReferenceInfo referenceInfo;
    private final Supplier<EObject> objectFactory;

    public FHIRDeserializer(
            FHIRIdentityInfo identityInfo,
            FHIRTypeInfo typeInfo,
            FHIRReferenceInfo referenceInfo,
            Supplier<EObject> objectFactory) {

        log.trace("FHIRDeserializer=>");
        this.identityInfo  = identityInfo;
        this.typeInfo      = typeInfo;
        this.referenceInfo = referenceInfo;
        this.objectFactory = objectFactory;
    }

    @Override
    public EObject deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        
        log.trace("deserialize=>");
        FHIRModule module = (FHIRModule) ctxt.getAttribute(FHIRModule.class);
        log.trace(">>> module.identityInfo   = {}", identityInfo);
        log.trace(">>> module.typeInfo       = {}", typeInfo);
        log.trace(">>> module.referenceInfo  = {}", referenceInfo);


        JsonNode rootNode = p.readValueAsTree();
        EObject eObject = objectFactory.get();

        if (eObject == null) {
            throw new IOException("Could not create EObject instance for deserialization.");
        }

        log.trace("Deserializing: {}", eObject.eClass().getName());

        EcoreIdentityInfo identityInfo = (EcoreIdentityInfo) ctxt.getAttribute(EcoreIdentityInfo.class);
        EcoreTypeInfo typeInfo = (EcoreTypeInfo)ctxt.getAttribute(EcoreTypeInfo.class);
        EcoreReferenceInfo referenceInfo = (EcoreReferenceInfo) ctxt.getAttribute(EcoreReferenceInfo.class);

        EObjectPropertyMap propertyMap = new FHIRPropertyMapBuilder(identityInfo, typeInfo, referenceInfo, 0).construct(ctxt, eObject.eClass());

        for (EObjectProperty property : propertyMap.getProperties()) {
            String jsonKey = property.getFieldName();
            
log.trace("property class: {}", property.getFieldName());

            if (rootNode.has(jsonKey)) {
                EObject value = null;

             log.trace("Here=={} instanceof {}", 1, property instanceof EObjectFeatureProperty);

                try {
                    if (property instanceof FHIREObjectProperty feoProp) {
                        feoProp.deserializeAndSet(p, value, ctxt, (Resource) eObject);

                        log.trace("Here=={}, {}", 2, p.currentValue());
                    } else {
                        log.debug("was not true");
                    }
                } catch (Exception e) {
                    log.warn("Failed to deserialize property '{}': {}", jsonKey, e.getMessage(), e);
                    continue;
                }

                if (value != null) {
             log.trace("Here=={}", 3);
                    if (property instanceof FHIREObjectProperty fProp) {
             log.trace("Here=={}", 4);
                        EStructuralFeature feature = fProp.getFeature();

                        if (feature.isMany()) {
                            safeAddAll(eObject, feature, value);
                        } else {
                            eObject.eSet(feature, value);
                        }

                        log.trace("Set {} = {}", jsonKey, value);
                    } else {
                        log.warn("Property '{}' is not an EObjectFeatureProperty — cannot access feature", jsonKey);
                    }
                }
            }
        }

        return eObject;
    }

    @SuppressWarnings("unchecked")
    private static void safeAddAll(EObject eObject, EStructuralFeature feature, EObject value) {
        if (feature.isMany() && value instanceof EList<?>) {
            ((EList<EObject>) eObject.eGet(feature)).addAll((EList<? extends EObject>) value);
        }
    }
}
