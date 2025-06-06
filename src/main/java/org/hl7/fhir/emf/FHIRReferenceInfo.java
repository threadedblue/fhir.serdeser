package org.hl7.fhir.emf;

import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.handlers.BaseURIHandler;

public class FHIRReferenceInfo extends EcoreReferenceInfo {

    public FHIRReferenceInfo() {
        super("reference", new BaseURIHandler());
    }
}