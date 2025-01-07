package org.hl7.fhir.emf;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.hl7.fhir.Element;
import org.hl7.fhir.StructureDefinition;
import org.hl7.fhir.StructureDefinitionSnapshot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FHIRProfilerTest {

	private static final Logger LOG = LoggerFactory.getLogger(FHIRProfilerTest.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		File file = new File("data/StructureDefinition-us-core-patient.xml");
		InputStream reader = null;
		try {
			reader = new FileInputStream(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject profile = null;
		try {
			profile = FHIRSDS.load(reader, Finals.SDS_FORMAT.XML);
			assertNotNull(profile);
			LOG.info("eObject=" + profile.eClass().getName());
			StructureDefinition sut = (StructureDefinition) profile;
			assertNotNull(sut);
			LOG.info("StructureDefinition=" + sut.getFhirVersion());
			LOG.info("StructureDefinition=" + sut.getDate());
			StructureDefinitionSnapshot sds = sut.getSnapshot();
			for (Element el : sds.getElement()) {
				LOG.trace(el.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		OutputStream out = FHIRProfiler.profileResource(profile);
		assertNotNull(out);
	}

}
