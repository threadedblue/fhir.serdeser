package org.hl7.fhir.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.FhirPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FHIRContext {

    private static final Logger log = LoggerFactory.getLogger(FHIRContext.class);

    private final EPackage fhirPackage;
    private final EFactory fhirFactory;

    public FHIRContext() {
        this.fhirPackage = FhirPackage.eINSTANCE;
        this.fhirFactory = FhirFactory.eINSTANCE;
    }

    public EPackage getFhirPackage() {
        return fhirPackage;
    }

    public EFactory getFhirFactory() {
        return fhirFactory;
    }

    public EClass getEClassByName(String name) {
        if (fhirPackage.getEClassifier(name) instanceof EClass eClass) {
            return eClass;
        } else {
            log.warn("EClass not found for name: {}", name);
            return null;
        }
    }

    public Object create(String typeName) {
        EClass eClass = getEClassByName(typeName);
        if (eClass != null) {
            return fhirFactory.create(eClass);
        }
        return null;
    }
}
