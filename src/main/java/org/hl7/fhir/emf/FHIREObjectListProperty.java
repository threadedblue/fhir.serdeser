package org.hl7.fhir.emf;

import java.io.IOException;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.emfjson.jackson.databind.property.EObjectFeatureProperty;
import org.hl7.fhir.emf.deser.PrimitiveListDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class FHIREObjectListProperty extends EObjectFeatureProperty {

    private final PrimitiveListDeserializer<EObject> listDeserializer;

    /**
     * @param feature  the EStructuralFeature (multi-valued primitive)
     * @param javaType the Jackson JavaType for List<PrimitiveType>
     * @param options  any EMFProperty options flags
     */
    public FHIREObjectListProperty(EStructuralFeature feature,
                                   JavaType javaType,
                                   int options) {
        super(feature, javaType, options);

        // 1) EMF factory for the primitive EClass
        EClass primitiveEClass = (EClass) feature.getEType();
        EFactory emfFactory = primitiveEClass.getEPackage().getEFactoryInstance();

        // 2) Supplier that creates new primitive instances
        Supplier<EObject> factory = () -> emfFactory.create(primitiveEClass);

        // 3) Lookup the “value” attribute on the primitive EClass
        EStructuralFeature valueFeature = primitiveEClass.getEStructuralFeature("value");
        if (valueFeature == null) {
            throw new IllegalStateException(
                "Primitive EClass " + primitiveEClass.getName() + " has no 'value' feature");
        }

        // 4) BiConsumer that sets the “value” slot via EMF’s dynamic API
        BiConsumer<EObject,String> setter = (obj, val) -> {
            obj.eSet(valueFeature, val);
        };

        // 5) Build the Jackson JavaType for List<primitive>
        Class<?> elementClass = (Class<?>) primitiveEClass.getInstanceClass();
        JavaType listType = TypeFactory.defaultInstance()
            .constructCollectionType(List.class, elementClass);

        // 6) Instantiate your PrimitiveListDeserializer with EMF factory & setter
        this.listDeserializer = new PrimitiveListDeserializer<>(factory, setter);
    }

    // @Override
    // public EList<EObject> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    //     @SuppressWarnings("unchecked")
    //     EList<EObject> values = (EList<EObject>) listDeserializer.deserialize(p, ctxt);
    //     return values;
    // }

    @Override
    public void deserializeAndSet(JsonParser p
                                    ,EObject current
                                    ,DeserializationContext ctxt
                                    ,Resource resource) throws IOException {
        // 1) Parse into a plain List<EObject>
        EList<EObject> javaList = (EList<EObject>) listDeserializer.deserialize(p, ctxt);

        // 2) Grab the live EList on the target EObject
        EObject target = (EObject) resource;
        @SuppressWarnings("unchecked")
        EList<EObject> eList = (EList<EObject>) target.eGet(getFeature());

        // 3) Replace its contents
        eList.clear();
        eList.addAll(javaList);
    }
}
