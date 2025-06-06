package org.hl7.fhir.emf.deser;

import java.util.List;
import java.util.function.Supplier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.FhirPackage;
import org.hl7.fhir.Id;
import org.hl7.fhir.emf.FHIRModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;

public class FHIRDeserializers extends SimpleDeserializers {

    private static final Logger log = LoggerFactory.getLogger(FHIRDeserializers.class);

    private final FHIRModule module;

    public FHIRDeserializers(FHIRModule module) {
        this.module = module;
    }

    @Override
    public JsonDeserializer<?> findBeanDeserializer(JavaType type,
                                                    DeserializationConfig config,
                                                    BeanDescription beanDesc) throws JsonMappingException {

        log.trace("findBeanDeserializer===>{}", type.getTypeName());

        Class<?> raw = type.getRawClass();

        // --- Handle EObject-derived FHIR resources ---
       if (EObject.class.isAssignableFrom(raw)) {
            log.trace("Returning FHIRDeserializer for {}", raw.getSimpleName());

            // Build a Supplier<EObject> that uses the EPackage/EFactory to create instances:
            Supplier<EObject> supplier = () -> {
                String classifierName = raw.getSimpleName(); // e.g., "Patient"
                // (You could also use module.getFactoryFor(raw), if you implement that.)
                return (EObject) FhirPackage.eINSTANCE
                    .getEClassifier(classifierName)
                    .getEPackage()
                    .getEFactoryInstance()
                    .create((org.eclipse.emf.ecore.EClass) FhirPackage.eINSTANCE.getEClassifier(classifierName));
            };

            // Pull identity/type/reference from module:
            return new FHIRDeserializer(
                module.getIdentityInfo(),
                module.getTypeInfo(),
                module.getReferenceInfo(),
                supplier
            );
        }

        // --- Handle EList<Primitive> ---
        if (EList.class.isAssignableFrom(raw) || List.class.isAssignableFrom(raw)) {
            JavaType contentType = type.getContentType();
            if (contentType != null) {
                Class<?> contentClass = contentType.getRawClass();

                // Primitive types
                if (contentClass == org.hl7.fhir.String.class) {
                    return new PrimitiveListDeserializer<org.hl7.fhir.String>(FhirFactory.eINSTANCE::createString, org.hl7.fhir.String::setValue);
                } else if (contentClass == Id.class) {
                    return new PrimitiveListDeserializer<org.hl7.fhir.Id>(FhirFactory.eINSTANCE::createId, org.hl7.fhir.Id::setValue);
                
                // else if (contentClass == Markdown.class)
                //     return new PrimitiveListDeserializer<>(FhirFactory.eINSTANCE::createMarkdown);
                // else if (contentClass == Uuid.class)
                //     return new PrimitiveListDeserializer<>(FhirFactory.eINSTANCE::createUuid);
                // else if (contentClass == Oid.class)
                //     return new PrimitiveListDeserializer<>(FhirFactory.eINSTANCE::createOid);

                // Enum support (example)
                // else if (contentClass == AllergyIntoleranceCategory.class)
                //     return new EnumListDeserializer<>(AllergyIntoleranceCategory.class);
            }
        }

        // --- Handle individual FHIR primitive types ---
        if (raw == Id.class) {

            log.trace("Deserializing=={}", raw.getName());

            return new PrimitiveDeserializer<org.hl7.fhir.Id> (
                FhirFactory.eINSTANCE::createId,
                org.hl7.fhir.Id::setValue
            );  
        }      
            // if (raw == Markdown.class)
        //     return new MarkdownDeserializer();
        // if (raw == Uuid.class)
        //     return new UuidDeserializer();
        // if (raw == Oid.class)
        //     return new OidDeserializer();
        if (raw == org.hl7.fhir.String.class) {

            log.trace("Deserializing=={}", raw.getName());

            return new PrimitiveDeserializer<org.hl7.fhir.String> (
                FhirFactory.eINSTANCE::createString,
                org.hl7.fhir.String::setValue
            );
        }

            return null;
        }
        return null;
    }

    // Base64Binary
// Boolean
// code
// date
// dateTime
// decimal
// id
// instant
// integer
// markdown
// oid
// positiveInt
// string
// time
// unsignedInt
// uri
// url
// uuid
// xhtml
}
