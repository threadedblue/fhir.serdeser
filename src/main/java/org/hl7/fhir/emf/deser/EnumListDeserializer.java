package org.hl7.fhir.emf.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnumListDeserializer<T extends Enum<T>> extends JsonDeserializer<List<T>> {

    private final Class<T> enumType;

    public EnumListDeserializer(Class<T> enumType) {
        this.enumType = enumType;
    }

    @Override
    public List<T> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        List<T> result = new ArrayList<>();

        if (p.currentToken() == JsonToken.START_ARRAY) {
            while (p.nextToken() != JsonToken.END_ARRAY) {
                String text = p.getText();
                try {
                    result.add(Enum.valueOf(enumType, text));
                } catch (IllegalArgumentException e) {
                    ctxt.reportInputMismatch(enumType, "Invalid value '%s' for enum %s", text, enumType.getSimpleName());
                }
            }
        } else {
            ctxt.reportWrongTokenException(this, JsonToken.START_ARRAY, "Expected start of array for enum list");
        }

        return result;
    }
}
