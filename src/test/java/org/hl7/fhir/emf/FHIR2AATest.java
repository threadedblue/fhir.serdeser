package org.hl7.fhir.emf;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.hl7.fhir.Bundle;
import org.hl7.fhir.BundleEntry;
import org.hl7.fhir.Observation;
import org.hl7.fhir.Patient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.io.Files;

class FHIR2AATest {

	private static final Logger LOG = LoggerFactory.getLogger(FHIR2AATest.class);
	private static final String delim = "|";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testFHIR2CSV() {
		
		File dir = new File("/Users/gcr/eccWk/FHIRSDSData/v4-synthea-fhir");
		File out = new File("/Users/gcr/eccWk/FHIRSDSData/v4-synthea-fhirVSV");
		File[] bundles = dir.listFiles();
		for (File file : Arrays.copyOfRange(bundles, 1, 5)) {
			InputStream reader = null;
			try {
				if (!out.exists()) {
					out.mkdir();
				}
				reader = new FileInputStream(file);
				EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.JSON);
				Bundle bundle = (Bundle) eObject;
				List<BundleEntry> entries = new ArrayList<>(bundle.getEntry().size());
				entries.addAll(bundle.getEntry());
				Collections.sort(entries, new Comparator<BundleEntry>() {
					  @Override
					  public int compare(BundleEntry entry1, BundleEntry entry2) {
						  String s1 = entry1.getResource().eContents().get(0).eClass().getName();
						  String s2 = entry2.getResource().eContents().get(0).eClass().getName();
					    return s1.compareTo(s2);
					  }
					});
				String oldResourceType = "";
				int idx = 1;
				for (BundleEntry entry : entries) {
					EObject eObject3 = entry.getResource().eContents().get(0);
					String resourceType = eObject3.eClass().getName();
					if(resourceType.equals(oldResourceType)) {
						idx++;
					} else {
						oldResourceType = resourceType;
						idx = 1;
					}
					String fileNameSansExt = Files.getNameWithoutExtension(file.getName());
					String vsvName = String.format("%s-%s[%02d].%s", fileNameSansExt, resourceType, idx, "vsv");
					File outFile  = new File(out, vsvName);
					LOG.info(vsvName);
				    FileWriter fw = new FileWriter(outFile.getAbsolutePath(), true);
				    LOG.debug(outFile.getName());
				    BufferedWriter bw = new BufferedWriter(fw);
					FHIR2AA aa = new FHIR2AA(eObject3);
					Table<String, String, String> tab = aa.toFHIRAA(eObject3);
					Set<String> cols = tab.columnKeySet();
					Collection<String> vals = tab.values();
					String row1 = String.format("%s%s%s", delim, String.join(delim, cols), delim);
					String row2 = String.format("%s%s%s%s", tab.rowKeySet().iterator().next(), delim, String.join(delim, vals), delim);
					bw.append(row1);
					bw.newLine();
					bw.append(row2);
					bw.newLine();
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	void testFHIRAABundle() {
		
	}

	@Test
	void testToFHIRAAPatient() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("data/Patient.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.XML);
		assertNotNull(eObject);
		Patient sut = (Patient) eObject;
		LOG.info("Patient-1=" + sut.eClass().getName());
		FHIR2AA f2p = new FHIR2AA(sut);
		Table<String, String, String> rcvs = f2p.toFHIRAA(eObject);
		assertNotNull(rcvs);
		for (Cell<String, String, String> cell : rcvs.cellSet()) {
			LOG.info(String.format("%s %s %s", cell.getRowKey(), cell.getColumnKey(), cell.getValue()));
		}
	}
	
	@Test
	void testToFHIRAAObservation1() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("/Users/gcr/eccWk/FHIRSDSData/examples-xml/Observation-example-f001-glucose.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.XML);
		assertNotNull(eObject);
		Observation sut = (Observation) eObject;
		LOG.info("Observation-1=" + sut.eClass().getName());
		FHIR2AA f2p = new FHIR2AA(sut);
		Table<String, String, String> rcvs = f2p.toFHIRAA(eObject);
		assertNotNull(rcvs);
		for (Cell<String, String, String> cell : rcvs.cellSet()) {
			LOG.info(String.format("%s, %s|%s", cell.getRowKey(), cell.getColumnKey(), cell.getValue()));
		}
	}
	
	@Test
	void testToFHIRAAObservation2() {
		InputStream reader = null;
		try {
			reader = new FileInputStream("/Users/gcr/eccWk/FHIRSDSData/examples-xml/Observation-example-f005-hemoglobin.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		EObject eObject = FHIRSerDeser.load(reader, Finals.SDS_FORMAT.XML);
		assertNotNull(eObject);
		Observation sut = (Observation) eObject;
		LOG.info("Observation-1=" + sut.eClass().getName());
		FHIR2AA f2p = new FHIR2AA(sut);
		Table<String, String, String> rcvs = f2p.toFHIRAA(eObject);
		assertNotNull(rcvs);
		for (Cell<String, String, String> cell : rcvs.cellSet()) {
			LOG.info(String.format("%s, %s|%s", cell.getRowKey(), cell.getColumnKey(), cell.getValue()));
		}
	}
}
