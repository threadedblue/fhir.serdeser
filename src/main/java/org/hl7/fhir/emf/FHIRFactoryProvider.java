package org.hl7.fhir.emf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.FhirPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FHIRFactoryProvider {

    private static final Logger log = LoggerFactory.getLogger(FHIRFactoryProvider.class);

    private final EPackage fhirPackage;
    private final EFactory fhirFactory;

    public FHIRFactoryProvider() {
        
        log.trace("FHIRFactoryProvider=>");

        this.fhirPackage = FhirPackage.eINSTANCE;
        this.fhirFactory = FhirFactory.eINSTANCE;
    }

    public EFactory getFactory() {
        return fhirFactory;
    }

    public EClass getEClass(String name) {
        if (fhirPackage.getEClassifier(name) instanceof EClass eClass) {
            return eClass;
        } else {
            log.warn("FHIRFactoryProvider: Unknown EClass '{}'", name);
            return null;
        }
    }

    public Object create(String classifierName) {
        EClass eClass = getEClass(classifierName);
        if (eClass != null) {
            return fhirFactory.create(eClass);
        }
        return null;
    }

    public boolean supports(String classifierName) {
        return getEClass(classifierName) != null;
    }
}
