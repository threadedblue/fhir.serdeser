package org.hl7.fhir.emf;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.databind.deser.ReferenceEntry;
import org.emfjson.jackson.module.EMFModule;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.emf.deser.FHIRDeserializers;
import org.hl7.fhir.emf.deser.FHIRListDeserializers;
import org.hl7.fhir.emf.deser.PrimitiveDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FHIRModule extends EMFModule {

    private static final Logger log = LoggerFactory.getLogger(FHIRModule.class);
	private static final AtomicInteger COUNTER = new AtomicInteger();
	private final int instanceId;

    public FHIRModule() {
		
			this.instanceId = COUNTER.incrementAndGet();
			log.trace("Creating FHIRModule instance #{}", instanceId);

        setTypeInfo(new FHIRTypeInfo());

		setIdentityInfo(new FHIRIdentityInfo());
		setReferenceInfo(new FHIRReferenceInfo());
        setDeserializers(new FHIRDeserializers());
		setReferenceDeserializer(new JsonDeserializer<ReferenceEntry>() {
			@Override
			public ReferenceEntry deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
				final EObject parent = EMFContext.getParent(ctxt);
				final EReference reference = EMFContext.getReference(ctxt);
				log.info("ReferenceDeserializer====>" + "parent=" + parent.eClass().getName() + " reference="
						+ reference.getName());

				if (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
					parser.nextToken();
				}

				return new ReferenceEntry.Base(parent, reference, parser.getText());
			}
		});
        // Register serializer for EObject
//        addSerializer(EObject.class, new FHIRSerializer());


        addDeserializer(org.hl7.fhir.String.class, new PrimitiveDeserializer<>(FhirFactory.eINSTANCE::createString, org.hl7.fhir.String::setValue));
    }

    @Override
    public void setupModule(SetupContext context) {
        super.setupModule(context);

		log.trace("setupModule==>{}", super.getReferenceInfo());

        context.addDeserializers(new FHIRDeserializers());       
        context.addDeserializers(new FHIRListDeserializers()); 
    }
}
