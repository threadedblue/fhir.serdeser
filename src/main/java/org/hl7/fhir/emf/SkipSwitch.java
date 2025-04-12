package org.hl7.fhir.emf;
import org.eclipse.emf.ecore.EObject;
import org.hl7.fhir.Id;
import org.hl7.fhir.Narrative;
import org.hl7.fhir.util.FhirSwitch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// Catalogs the EObjects that are not to be processed. i.e. "Skipped"
//
public class SkipSwitch extends FhirSwitch<Boolean> {
	private static final Logger LOG = LoggerFactory.getLogger(SkipSwitch.class);
	@Override
	public Boolean caseId(Id n) {
		LOG.trace("skip Id");
		return true;
	}
	
	@Override
	public Boolean caseNarrative(Narrative n) {
		LOG.trace("skip Narrative");
		return true;
	}
	
	@Override
	public Boolean defaultCase(EObject object) {
		return false;
	}
}
