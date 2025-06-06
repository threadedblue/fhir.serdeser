package org.hl7.fhir.emf;

import org.eclipse.emf.ecore.EObject;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.utils.ValueReader;
import org.emfjson.jackson.utils.ValueWriter;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.Id;
import org.hl7.fhir.Resource;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * A FHIR‐aware IdentityInfo that tells EMF‐Jackson:
 *  • Which FHIR feature is the “id” of a Resource
 *  • Which feature holds the “versionId” inside meta
 *  • How to read and write those values
 */
public class FHIRIdentityInfo extends EcoreIdentityInfo {

    public FHIRIdentityInfo() {
        super(
            "id",
            new ValueReader<Object, String>() {
                @Override
                public String readValue(Object value, DeserializationContext context) {
                    // The JSON "id" field is a plain string (e.g. "123"), so just return it.
                    return (value == null ? null : value.toString());
                }
            },
            new ValueWriter<EObject, Object>() {
                @Override
                public Id writeValue(EObject object, SerializerProvider context) {
                    if (object instanceof Resource) {
                        Id idObj = FhirFactory.eINSTANCE.createId();
                        idObj.setValue(((Resource) object).getId().getValue());
                        return idObj;
                    }
                    return null;
                }
            }
        );
    }
}
