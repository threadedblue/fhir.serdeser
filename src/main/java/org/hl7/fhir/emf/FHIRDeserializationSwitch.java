package org.hl7.fhir.emf;

import java.io.IOException;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.hl7.fhir.Address;
import org.hl7.fhir.Base64Binary;
import org.hl7.fhir.Boolean;
import org.hl7.fhir.BundleType;
import org.hl7.fhir.BundleTypeEnum;
import org.hl7.fhir.Canonical;
import org.hl7.fhir.Code;
import org.hl7.fhir.ContactPointSystem;
import org.hl7.fhir.ContactPointSystemEnum;
import org.hl7.fhir.ContactPointUse;
import org.hl7.fhir.ContactPointUseEnum;
import org.hl7.fhir.Date;
import org.hl7.fhir.DateTime;
import org.hl7.fhir.Decimal;
import org.hl7.fhir.FhirFactory;
import org.hl7.fhir.IdentifierUse;
import org.hl7.fhir.IdentifierUseEnum;
import org.hl7.fhir.Instant;
import org.hl7.fhir.Integer;
import org.hl7.fhir.ResourceContainer;
import org.hl7.fhir.String;
import org.hl7.fhir.Time;
import org.hl7.fhir.Uri;
import org.hl7.fhir.Url;
import org.hl7.fhir.util.FhirSwitch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FHIRDeserializationSwitch extends FhirSwitch<EObject> {

	private static final Logger log = LoggerFactory.getLogger(FHIRDeserializationSwitch.class);

	private final EObject instance; // The object to populate
	private final JsonParser p;

	public FHIRDeserializationSwitch(EObject instance, JsonParser p) {
		this.instance = instance;
		this.p = p;
	}

	@Override
	public EObject caseAddress(Address resource) {
		JsonNode dataNode;
		try {
			dataNode = p.readValueAs(JsonNode.class);
			List<java.lang.String> line = dataNode.findValuesAsText("line");
			((ObjectNode)dataNode).remove("line");
			log.trace("beClass=" + line);
			EList<Address> eList = new BasicEList<Address>();
			Address address = FhirFactory.eINSTANCE.createAddress();
			eList.add(address);
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseBase64Binary(Base64Binary resource) {
		try {
			resource.setValue(p.getBinaryValue(null));
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseBoolean(Boolean resource) {
		try {
			resource.setValue(p.getBooleanValue());
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseBundleType(BundleType resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(BundleTypeEnum.getByName(s));
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseCanonical(Canonical resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(p.getValueAsString());
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseCode(Code resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(p.getValueAsString());
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseContactPointSystem(ContactPointSystem resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(ContactPointSystemEnum.getByName(s));
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseContactPointUse(ContactPointUse resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(ContactPointUseEnum.getByName(s));
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseDate(Date resource) {
		try {
			java.lang.String s = p.getValueAsString();
			XMLGregorianCalendar XCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(s);
			resource.setValue(XCal);
		} catch (IOException e) {
			log.error("", e);
		} catch (DatatypeConfigurationException e) {
			log.error("", e);
		} catch (Exception e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseDateTime(DateTime resource) {
		try {
			java.lang.String s = p.getValueAsString();
			XMLGregorianCalendar XCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(s);
			resource.setValue(XCal);
		} catch (IOException e) {
			log.error("", e);
		} catch (DatatypeConfigurationException e) {
			log.error("", e);
		} catch (Exception e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseDecimal(Decimal resource) {
		try {
			resource.setValue(p.getDecimalValue());
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseIdentifierUse(IdentifierUse resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(IdentifierUseEnum.getByName(s));
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseInstant(Instant resource) {
		try {
			java.lang.String s = p.getValueAsString();
			XMLGregorianCalendar XCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(s);
			resource.setValue(XCal);
		} catch (IOException e) {
			log.error("", e);
		} catch (DatatypeConfigurationException e) {
			log.error("", e);
		} catch (Exception e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseInteger(Integer resource) {
		try {
			resource.setValue(p.getIntValue());
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseResourceContainer(ResourceContainer resource) {

		try {
			JsonNode dataNode = p.readValueAs(JsonNode.class);
			EObject eObject = FHIRSDS.loadJSON(dataNode);
			java.lang.String s = dataNode.get("resourceType").textValue();
			log.trace("beClass=" + s);
		} catch (SecurityException e) {
			log.error("", e);
		} catch (IllegalArgumentException e) {
			log.error("", e);
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseString(String resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(s);
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseTime(Time resource) {
		Time  time = FhirFactory.eINSTANCE.createTime();
		try {
		    java.lang.String s = p.getValueAsString();
		    XMLGregorianCalendar XCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(s);
		    time.setValue(XCal);
		} catch (IOException e) {
			log.error("", e);
		} catch (DatatypeConfigurationException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseUri(Uri resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(s);
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject caseUrl(Url resource) {
		try {
			java.lang.String s = p.getValueAsString();
			resource.setValue(s);
		} catch (IOException e) {
			log.error("", e);
		}
		return resource;
	}

	@Override
	public EObject defaultCase(EObject object) {
		// 🔹 Default case: return as-is (let standard deserialization proceed)
		return instance;
	}
}
