package org.hl7.fhir.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FHIR2Path {

	private static final Logger log = LoggerFactory.getLogger(FHIR2Path.class);
	
	public static void listFHIRPaths(EObject resource) {
	    // Get the EClass of the resource
	    EClass eClass = resource.eClass();
	    
	    // Get the resource name (e.g., Patient, AdverseEvent)
	    String resourceName = eClass.getName();
	    
	    System.out.println("FHIRPaths for resource: " + resourceName);
	    
	    // Iterate over all structural features (attributes and references)
	    for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
	        // Construct the FHIRPath
	        String fhirPath = resourceName + "." + feature.getName();
	        
	        // Print the FHIRPath
	        System.out.println(fhirPath);
	    }
	}

	public static String toFhirPath(EAttribute eAttribute, EObject eObject) {
		
		List<java.lang.String> paths = toSegList(eAttribute, eObject);
		
		return String.join(".", paths.toArray(new String[paths.size()]));
	}


	public static List<java.lang.String> toSegList(EAttribute eAttribute, EObject eObject) {

		List<java.lang.String> paths = new ArrayList<>();
		log.info(eObject.eClass().getName());
		String name = eAttribute.getName();
		Object value = eObject.eGet(eAttribute);

//		while (itr.hasNext()) {
//			EObject o = itr.next();
//			List<java.lang.String> stk = buildPath(o);
//			Collections.reverse(stk);
//			log.info("stk=" + stk.toString());
////			stk.push(o.eClass().getName());
//			StringBuilder bld = new StringBuilder();
//			bld.append(java.lang.String.join(".", stk));
//			log.info("bld=" + bld.toString());
//		}
		return paths;
	}

	public static List<java.lang.String> toSegList(EReference eReference, EObject eObject) {

		List<java.lang.String> paths = new ArrayList<>();
		log.info(eObject.eClass().getName());
//		String name = eReference.getName();
//		paths.add(name);
//		while (itr.hasNext()) {
//			EObject o = itr.next();
//			List<java.lang.String> stk = buildPath(o);
//			Collections.reverse(stk);
//			log.info("stk=" + stk.toString());
////			stk.push(o.eClass().getName());
//			StringBuilder bld = new StringBuilder();
//			bld.append(java.lang.String.join(".", stk));
//			log.info("bld=" + bld.toString());
//		}
		return paths;
	}
	
	public static List<java.lang.String> buildPath(EObject eObject) {
		List<java.lang.String> stk = new ArrayList<java.lang.String>();
		EObject eContainer = eObject.eContainer();
		while (eContainer != null) {
			stk.add(eContainer.eClass().getName());
			eContainer = eContainer.eContainer();
		}
		return stk;
	}
}
