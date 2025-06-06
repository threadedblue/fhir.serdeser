package org.hl7.fhir.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.property.EObjectFeatureProperty;
import org.emfjson.jackson.databind.property.EObjectProperty;
import org.emfjson.jackson.databind.property.EObjectPropertyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DatabindContext;

public class FHIRPropertyMapBuilder extends EObjectPropertyMap.Builder {

    public FHIRPropertyMapBuilder(EcoreIdentityInfo identityInfo, EcoreTypeInfo typeInfo,
            EcoreReferenceInfo referenceInfo, int features) {
        super(identityInfo, typeInfo, referenceInfo, features);
    }

    private static final Logger log = LoggerFactory.getLogger(FHIRPropertyMapBuilder.class);

    // @Override
    // public EObjectPropertyMap construct(DatabindContext ctxt, EClass type) {
    //     // 1) Let EMF-JSON build its normal map
    //     EObjectPropertyMap map = super.construct(ctxt, type);

    //     // 2) Now walk through and swap in your FHIREObjectProperty only
    //     //    for the features you actually need
    //     List<EObjectProperty> newProps = new ArrayList<>();
    //     for (EObjectProperty prop : map.getProperties()) {
    //         if (prop instanceof EObjectFeatureProperty efp) {
    //             // Now both compile‐time and runtime know you have an EObjectFeatureProperty
    //             EStructuralFeature feature = efp.getFeature();
    //             JavaType javaType = efp.getJavaType();
    //             int opts = efp.getOptions();

    //             if (isPrimitiveList(feature)) {
    //                 log.trace("Wrapping primitive list: {}", feature.getName());
    //                 newProps.add(new FHIREObjectProperty(feature, javaType, opts));
    //             } else {
    //                 newProps.add(prop);
    //         }
    //         }
    //      }

    //     Iterable<EObjectProperty> props = map.getProperties();
    //     if (props instanceof Collection<?>) {
    //         Collection<EObjectProperty> coll = (Collection<EObjectProperty>) props;
    //         coll.clear();
    //         coll.addAll(newProps);
    //     }
    //     return map;
    // }
@Override
public EObjectPropertyMap construct(DatabindContext ctxt, EClass type) {
  EObjectPropertyMap map = super.construct(ctxt, type);

  // Snapshot to avoid CME
  List<EObjectProperty> newProps = new ArrayList<>();
  for (EObjectProperty prop : map.getProperties()) {
    if (prop instanceof EObjectFeatureProperty efp) {
      EStructuralFeature feature = efp.getFeature();
      String name = feature.getName();
      if (Finals.FHIR_PRIMITIVES.contains(name)) {
        log.trace("Wrapping primitive {} (many={})", name, feature.isMany());
        if (feature.isMany()) {
          // multi-valued primitive: use your list-deserializer wrapper
          newProps.add(new FHIREObjectListProperty(feature,
                                                   efp.getJavaType(),
                                                   efp.getOptions()));
        } else {
          // single-valued primitive: use your single-deserializer wrapper
          newProps.add(new FHIREObjectProperty(feature,
                                               efp.getJavaType(),
                                               efp.getOptions()));
        }
        continue; 
      }
    }
    // all other props stay as-is
    newProps.add(prop);
  }

  // Replace in-place
   Collection<EObjectProperty> coll = (Collection<EObjectProperty>) map.getProperties();
  coll.clear();
  coll.addAll(newProps);

  return map;
}
    /**
     * Heuristic to identify FHIR primitive lists by class name.
     */
private boolean isPrimitiveList(EStructuralFeature feature) {
    if (!feature.isMany()) {
        return false;
    }

    EClassifier type = feature.getEType();
    String classifier = type.getInstanceClassName();
log.debug("classifier=={}", classifier);
    String primitiveName = type.getName();

    // normalize to the FHIR type token (lower-case for data types)
    String key = primitiveName.toLowerCase(Locale.ROOT);
log.debug("contains(key) key=={} {}", key, Finals.FHIR_PRIMITIVES.contains(key));
    return Finals.FHIR_PRIMITIVES.contains(key);
}


    private boolean isPrimitiveTypeName(String name) {
//        String name = feature.getName();
        return name.endsWith("String")
            || name.endsWith("Id")
            || name.endsWith("Code")
            || name.endsWith("Boolean")
            || name.endsWith("Date")
            || name.endsWith("DateTime")
            || name.endsWith("Time")
            || name.endsWith("Decimal")
            || name.endsWith("Integer")
            || name.endsWith("PositiveInt")
            || name.endsWith("UnsignedInt")
            || name.endsWith("Markdown")
            || name.endsWith("Base64Binary")
            || name.endsWith("Uri")
            || name.endsWith("Url")
            || name.endsWith("Uuid")
            || name.endsWith("Oid")
            || name.endsWith("Instant")
            || name.endsWith("Xhtml");
    }
}
