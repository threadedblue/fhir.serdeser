package org.hl7.fhir.emf.deser;

import java.util.Base64;

import org.hl7.fhir.Base64Binary;
import org.hl7.fhir.FhirFactory;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;

public class FHIRListDeserializers extends Deserializers.Base {

    @Override
    public JsonDeserializer<?> findCollectionDeserializer(
        CollectionType type,
        DeserializationConfig config,
        BeanDescription beanDesc,
        TypeDeserializer elementTypeDeserializer,
        JsonDeserializer<?> elementDeserializer
    ) throws JsonMappingException {

        Class<?> contentClass = type.getContentType().getRawClass();

    if (contentClass == Base64Binary.class) {
        return new PrimitiveListDeserializer<Base64Binary>(
            FhirFactory.eINSTANCE::createBase64Binary,
            (b, v) -> b.setValue(Base64.getDecoder().decode(v))
        );

        // } else if (contentClass == Boolean.class) {
        //     return new PrimitiveListDeserializer<Boolean>(
        //         FhirFactory.eINSTANCE::createBoolean,
        //         Boolean::setValue
        //     );
        // } else if (contentClass == Code.class) {
        //     return new PrimitiveListDeserializer<Code>(
        //         FhirFactory.eINSTANCE::createCode,
        //         Code::setValue
        //     );
        // } else if (contentClass == Date.class) {
        //     return new PrimitiveListDeserializer<Date>(
        //         FhirFactory.eINSTANCE::createDate,
        //         Date::setValue
        //     );
        // } else if (contentClass == DateTime.class) {
        //     return new PrimitiveListDeserializer<DateTime>(
        //         FhirFactory.eINSTANCE::createDateTime,
        //         DateTime::setValue
        //     );
        // } else if (contentClass == Decimal.class) {
        //     return new PrimitiveListDeserializer<Decimal>(
        //         FhirFactory.eINSTANCE::createDecimal,
        //         Decimal::setValue
        //     );
        // } else if (contentClass == Id.class) {
        //     return new PrimitiveListDeserializer<Id>(
        //         FhirFactory.eINSTANCE::createId,
        //         Id::setValue
        //     );
        // } else if (contentClass == Instant.class) {
        //     return new PrimitiveListDeserializer<Instant>(
        //         FhirFactory.eINSTANCE::createInstant,
        //         Instant::setValue
        //     );
        // } else if (contentClass == Integer.class) {
        //     return new PrimitiveListDeserializer<Integer>(
        //         FhirFactory.eINSTANCE::createInteger,
        //         Integer::setValue
        //     );
        // } else if (contentClass == Markdown.class) {
        //     return new PrimitiveListDeserializer<Markdown>(
        //         FhirFactory.eINSTANCE::createMarkdown,
        //         Markdown::setValue
        //     );
        // } else if (contentClass == Oid.class) {
        //     return new PrimitiveListDeserializer<Oid>(
        //         FhirFactory.eINSTANCE::createOid,
        //         Oid::setValue
        //     );
        // } else if (contentClass == PositiveInt.class) {
        //     return new PrimitiveListDeserializer<PositiveInt>(
        //         FhirFactory.eINSTANCE::createPositiveInt,
        //         PositiveInt::setValue
        //     );
        } else if (contentClass == org.hl7.fhir.String.class) {
            return new PrimitiveListDeserializer<org.hl7.fhir.String>(
                FhirFactory.eINSTANCE::createString,
                org.hl7.fhir.String::setValue
            );
        // } else if (contentClass == Time.class) {
        //     return new PrimitiveListDeserializer<Time>(
        //         FhirFactory.eINSTANCE::createTime,
        //         Time::setValue
        //     );
        // } else if (contentClass == UnsignedInt.class) {
        //     return new PrimitiveListDeserializer<UnsignedInt>(
        //         FhirFactory.eINSTANCE::createUnsignedInt,
        //         UnsignedInt::setValue
        //     );
        // } else if (contentClass == Uri.class) {
        //     return new PrimitiveListDeserializer<Uri>(
        //         FhirFactory.eINSTANCE::createUri,
        //         Uri::setValue
        //     );
        // } else if (contentClass == Url.class) {
        //     return new PrimitiveListDeserializer<Url>(
        //         FhirFactory.eINSTANCE::createUrl,
        //         Url::setValue
        //     );
        // } else if (contentClass == Uuid.class) {
        //     return new PrimitiveListDeserializer<Uuid>(
        //         FhirFactory.eINSTANCE::createUuid,
        //         Uuid::setValue
        //     );
        // } else if (contentClass == Xhtml.class) {
        //     return new PrimitiveListDeserializer<Xhtml>(
        //         FhirFactory.eINSTANCE::createXhtml,
        //         Xhtml::setValue
        //     );
        // }
        } else {
            return null;
        }
    }
}