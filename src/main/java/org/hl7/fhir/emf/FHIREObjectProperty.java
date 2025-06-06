package org.hl7.fhir.emf;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.property.EObjectFeatureProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;

public class FHIREObjectProperty extends EObjectFeatureProperty {

    private static final Logger log = LoggerFactory.getLogger(FHIREObjectProperty.class);

    private final EStructuralFeature feature;
    private final JavaType type;
    private final int options;

    public FHIREObjectProperty(EStructuralFeature feature, JavaType type, int options) {
        super(feature, type, options);
        this.feature = feature;
        this.type = type;
        this.options = options;
    }

    public EStructuralFeature getFeature() {
        return feature;
    }

    @Override
    public EObject deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        
        log.trace("deserialize=>");

        return ctxt.readValue(parser, type);
    }

    @Override
    public String getFieldName() {
        return feature.getName();
    }

    @Override
    public void serialize(EObject bean, JsonGenerator jg, SerializerProvider provider) throws IOException {
        throw new UnsupportedOperationException("Unimplemented method 'serialize'");
    }

    @Override
    public void deserializeAndSet(JsonParser jp, EObject current, DeserializationContext ctxt, Resource resource)
            throws IOException {
        throw new UnsupportedOperationException("Unimplemented method 'deserializeAndSet'");
    }
}
