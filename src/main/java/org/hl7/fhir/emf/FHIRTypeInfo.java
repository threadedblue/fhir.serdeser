package org.hl7.fhir.emf;

import org.eclipse.emf.ecore.EClass;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.utils.ValueReader;
import org.emfjson.jackson.utils.ValueWriter;
import org.hl7.fhir.FhirPackage;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;

public class FHIRTypeInfo extends EcoreTypeInfo {

    public FHIRTypeInfo() {
        super(
            // 1) The JSON property that holds the resource type:
            "resourceType",

            // 2) ValueReader: given the resourceType string, return the matching EClass
            new ValueReader<String, EClass>() {
                @Override
                public EClass readValue(String value, DeserializationContext context) {
                    // Look up the EClass in the FHIR R4 package by name
                    return (EClass) FhirPackage.eINSTANCE.getEClassifier(value);
                }
            },

            // 3) ValueWriter: given an EClass, write out its name as the resourceType
            new ValueWriter<EClass, String>() {
                @Override
                public String writeValue(EClass value, SerializerProvider context) {
                    return value.getName();
                }
            }
        );
    }
}

