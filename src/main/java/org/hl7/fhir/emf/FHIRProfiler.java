package org.hl7.fhir.emf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.hl7.fhir.FhirPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3._1999.xhtml.XhtmlPackage;
import org.w3.xml._1998.namespace.NamespacePackage;

import com.fasterxml.jackson.core.JsonProcessingException;

public class FHIRProfiler {

	private static final Logger LOG = LoggerFactory.getLogger(FHIRProfiler.class);

	private static ResourceSet resourceSet = new ResourceSetImpl();
	private static Resource resource;
	
	static {
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(FhirPackage.eNS_URI, FhirPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(XhtmlPackage.eNS_URI, XhtmlPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(NamespacePackage.eNS_URI, NamespacePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	}

	public static OutputStream profileResource(EObject eObject) {
		URI ecoreURI =  URI.createFileURI("data/fhir.ecore");
		resource = resourceSet.getResource(ecoreURI, true);
		ByteArrayOutputStream writer = null;
		try {
			writer = new ByteArrayOutputStream();
			resource.save(System.out, Collections.EMPTY_MAP);
			writer.close();
		} catch (JsonProcessingException e) {
			LOG.error("", e);
		} catch (IOException e) {
			LOG.error("", e);
		}
		return writer;

	}
}
