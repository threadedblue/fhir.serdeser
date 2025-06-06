package org.hl7.fhir.emf.deser;


import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PrimitiveDeserializer<T extends EObject> extends JsonDeserializer<T> {

    private static final Logger log = LoggerFactory.getLogger(PrimitiveDeserializer.class);

    private final Supplier<T> factory;
    private final BiConsumer<T, String> setter;

    public PrimitiveDeserializer(Supplier<T> factory, BiConsumer<T, String> setter) {
        this.factory = factory;
        this.setter = setter;
    }

    @Override
    public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        
        log.trace("deserialize=>");

        T instance = factory.get();
        setter.accept(instance, p.getText());
        return instance;
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
