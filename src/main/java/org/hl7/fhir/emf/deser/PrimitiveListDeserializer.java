package org.hl7.fhir.emf.deser;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PrimitiveListDeserializer<T> extends JsonDeserializer<EList<T>> {

    private static final Logger log = LoggerFactory.getLogger(PrimitiveListDeserializer.class);

    private final Supplier<T> factory;
    private final BiConsumer<T, String> setter;

    public PrimitiveListDeserializer(Supplier<T> factory, BiConsumer<T, String> setter) {
        this.factory = factory;
        this.setter = setter;
    }

    @Override
    public EList<T> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        
        log.trace("deserialize=>");

        EList<T> result = new BasicEList<>();

        if (p.isExpectedStartArrayToken()) {
            while (p.nextToken() != JsonToken.END_ARRAY) {
                T instance = factory.get();
                setter.accept(instance, p.getText());
                result.add(instance);
            }
        } else {
            // Support single value as implicit list
            T instance = factory.get();
            setter.accept(instance, p.getText());
            result.add(instance);
        }

        return result;
    }
}
