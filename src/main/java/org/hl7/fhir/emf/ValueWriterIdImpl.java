package org.hl7.fhir.emf;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emfcloud.jackson.utils.ValueWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.SerializerProvider;

public class ValueWriterIdImpl implements ValueWriter<EObject, Object> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ValueWriterIdImpl.class);
	
	@Override
	public java.lang.String writeValue(EObject value, SerializerProvider context) {
		LOG.info("write value");
		return "SSS";
	}
}
