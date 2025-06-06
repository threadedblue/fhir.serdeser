package org.hl7.fhir.emf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.emfjson.jackson.annotations.EcoreIdentityInfo;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.hl7.fhir.FhirPackage;
import org.hl7.fhir.emf.Finals.SDS_FORMAT;
import org.hl7.fhir.emf.deser.BundleTypeDeserializer;
import org.hl7.fhir.emf.deser.enm.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3._1999.xhtml.XhtmlPackage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FHIRSerDeser {

	private static final Logger log = LoggerFactory.getLogger(FHIRSerDeser.class);

	private static ResourceSet resourceSet = new ResourceSetImpl();
	private static Resource resource;
	private static FHIRModule module = new FHIRModule();

	private static ObjectMapper mapper = new ObjectMapper();

	static {
		// This is suppoed to enable JSON arrays to be parsed as Lists.
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		// Let us prepare Ecore for job at hand.
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(FhirPackage.eNS_URI, FhirPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(XhtmlPackage.eNS_URI, XhtmlPackage.eINSTANCE);
//		resourceSet.getPackageRegistry().put(NamespacePackage.eNS_URI, NamespacePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(XMLNamespacePackage.eNS_URI, XMLNamespacePackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

// 		We are not supporting RDF at this time.  There seems to be no demand.
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ttl", new TTLResourceFactory());
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("nt", new NTResourceFactory());

// 		module.addSerializer(org.hl7.fhir.Base64Binary.class, new Base64Serializer());
// 		module.addSerializer(org.hl7.fhir.Boolean.class, new BooleanSerializer());
// 		module.addSerializer(org.hl7.fhir.Code.class, new CodeSerializer());
// 		module.addSerializer(org.hl7.fhir.Date.class, new DateSerializer());
// 		module.addSerializer(org.hl7.fhir.DateTime.class, new DateTimeSerializer());
// 		module.addSerializer(org.hl7.fhir.Decimal.class, new DecimalSerializer());
// 		module.addSerializer(org.hl7.fhir.Instant.class, new InstantSerializer());
// 		module.addSerializer(org.hl7.fhir.Integer.class, new IntegerSerializer());
// 		module.addSerializer(org.hl7.fhir.String.class, new StringSerializer());
// 		module.addSerializer(org.hl7.fhir.Time.class, new TimeSerializer());
// 		module.addSerializer(org.hl7.fhir.Uri.class, new UriSerializer());
// 		module.addSerializer(org.hl7.fhir.Url.class, new UrlSerializer());

// 		module.addDeserializer(org.hl7.fhir.Base64Binary.class, new Base64Deserializer());
// 		module.addDeserializer(org.hl7.fhir.Boolean.class, new BooleanDeserializer());
// 		module.addDeserializer(org.hl7.fhir.BundleType.class, new BundleTypeDeserializer());
// 		module.addDeserializer(org.hl7.fhir.Canonical.class, new CanonicalDeserializer());
// 		module.addDeserializer(org.hl7.fhir.Code.class, new CodeDeserializer());

// 		module.addDeserializer(org.hl7.fhir.Date.class, new DateDeserializer());
// 		module.addDeserializer(org.hl7.fhir.DateTime.class, new DateTimeDeserializer());
// 		module.addDeserializer(org.hl7.fhir.Decimal.class, new DecimalDeserializer());

// 		module.addDeserializer(org.hl7.fhir.Instant.class, new InstantDeserializer());
// 		module.addDeserializer(org.hl7.fhir.Integer.class, new IntegerDeserializer());
// 		module.addDeserializer(org.hl7.fhir.String.class, new StringDeserializer());
// 		module.addDeserializer(org.hl7.fhir.Time.class, new TimeDeserializer());
// 		module.addDeserializer(org.hl7.fhir.Uri.class, new UriDeserializer());
// 		module.addDeserializer(org.hl7.fhir.Url.class, new UrlDeserializer());
// 		module.addDeserializer(org.hl7.fhir.BundleType.class, new BundleTypeDeserializer());
// 		module.addDeserializer(org.hl7.fhir.Canonical.class, new CanonicalDeserializer());

// 		//		module.addDeserializer(org.hl7.fhir.BundleEntry.class, new BundleEntryDeserializer());
// 		module.addDeserializer(ResourceContainer.class, new ResourceContainerDeserializer());
// //		module.addDeserializer(BundleType.class, new BundleTypeDeserializer());
// 		addEnumDeserializers();

		mapper.registerModule(module);
		mapper.setConfig(
			mapper.getDeserializationConfig()
				.withAttribute(ResourceSet.class, resourceSet))
			.setConfig(
			mapper.getSerializationConfig()
				.withAttribute(ResourceSet.class, resourceSet));

		mapper.setConfig(
			mapper.getDeserializationConfig()
				.withAttribute(FHIRModule.class, module))
			.setConfig(
			mapper.getSerializationConfig()
				.withAttribute(FHIRModule.class, module));

		mapper.setConfig(mapper.getDeserializationConfig()
                   .withAttribute(EcoreIdentityInfo.class, module.getIdentityInfo()))
  			.setConfig(mapper.getSerializationConfig()
                   .withAttribute(EcoreIdentityInfo.class, module.getIdentityInfo()));

		mapper.setConfig(mapper.getDeserializationConfig()
                   .withAttribute(EcoreTypeInfo.class, module.getTypeInfo()))
  			.setConfig(mapper.getSerializationConfig()
                   .withAttribute(EcoreTypeInfo.class, module.getTypeInfo()));

				
		mapper.setConfig(mapper.getDeserializationConfig()
                   .withAttribute(EcoreReferenceInfo.class, module.getReferenceInfo()))
  			.setConfig(mapper.getSerializationConfig()
                   .withAttribute(EcoreReferenceInfo.class, module.getReferenceInfo()));
	}

	public static EObject load(InputStream reader, SDS_FORMAT format) {
		log.trace("load==>");
		switch (format) {
		case XML:
			return loadXML(reader);
		case JSON:
			return loadJSON(reader);
		case ECORE:
			return loadEcore(reader);
//		case RDF_TTL:
//			return loadRDF(reader, RDFFormat.TURTLE);
//		case RDF_N3:
//			return loadRDF(reader, RDFFormat.NTRIPLES);
		default:
			return null;
		}
	}

	public static EObject loadXML(InputStream reader) {
		log.trace("loadXML==>");
		URI uri = assembleURI(Finals.SDS_FORMAT.XML);

		try {
			resource = resourceSet.createResource(uri);
			resource.load(reader, Collections.EMPTY_MAP);
			EList<EObject> eList = resource.getContents();
			if (eList.size() > 0) {
				EObject eObject = (EObject) resource.getContents().get(0);
				return eObject;
			} else {
				log.error("json=" + resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().get("json"));
				log.error("xml=" + resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().get("xml"));
				log.error("Resource had no contents; returning null");
			}
		} catch (IOException e) {
			log.error("", e);
		} catch (ClassCastException e) {
			log.error("Cast", e);
		} catch (NullPointerException e) {
			log.debug("reader=" + reader);
			log.debug("uri=" + uri);
			log.debug("resourceSet=" + resourceSet);
			log.debug("resource=" + resource);
			for (Map.Entry<java.lang.String, Object> entry : resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap().entrySet()) {
				log.debug("key=" + entry.getKey() + " value=" + entry.getValue().getClass().getName());
			}
			log.error("NPE", e);
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}

	public static EObject loadJSON(InputStream reader) {
		log.trace("loadJSON==>");
		EObject eObject = null;
		try {
			JsonNode jn = mapper.readTree(reader);
			log.info("Checking required fields before parsing...");

			checkJsonField(jn, "resourceType");
//			checkJsonField(jn, "snapshot");  // Make sure it's available
			checkJsonField(jn, "name");      // Additional key checks
			
			removeExtensions(jn);
			eObject = loadJSON(jn);
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return eObject;
	}

	public static EObject loadEcore(InputStream reader) {
		URI uri = assembleURI(Finals.SDS_FORMAT.ECORE);
		try {
			resource = resourceSet.createResource(uri);
			resource.load(reader, Collections.EMPTY_MAP);
			EList<EObject> eList = resource.getContents();
			if (eList.size() > 0) {
				EObject eObject = (EObject) resource.getContents().get(0);
				return eObject;
			} else {
				log.error("json=" + resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().get("json"));
				log.error("xml=" + resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().get("xml"));
				log.error("Resource had no contents; returning null");
			}
		} catch (IOException e) {
			log.error("", e);
		} catch (ClassCastException e) {
			log.error("Cast", e);
		} catch (NullPointerException e) {
			log.debug("reader=" + reader);
			log.debug("uri=" + uri);
			log.debug("resourceSet=" + resourceSet);
			log.debug("resource=" + resource);
			for (Map.Entry<java.lang.String, Object> entry : resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap().entrySet()) {
				log.debug("key=" + entry.getKey() + " value=" + entry.getValue().getClass().getName());
			}
			log.error("NPE", e);
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}

	private static void checkJsonField(JsonNode node, String fieldName) {
		if (!node.has(fieldName) || node.get(fieldName).isNull()) {
			log.error("JSON is missing required field: " + fieldName);
		} else {
			log.info("Field '" + fieldName + "' found: " + node.get(fieldName).toString());
		}
	}

    private static void removeExtensions(JsonNode node) {
        if (node.isObject()) {
            // Cast to ObjectNode to allow modification
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.remove("extension"); // Remove "extension" if it exists
            
            // Recursively check all children
            objectNode.fields().forEachRemaining(entry -> removeExtensions(entry.getValue()));
        } else if (node.isArray()) {
            // Recursively clean each element in an array
            for (JsonNode item : node) {
                removeExtensions(item);
            }
        }
    }

	public static EObject loadJSON(JsonNode jn) {
		log.trace("loadJSON==>2");
		URI uri = assembleURI(Finals.SDS_FORMAT.JSON);
		resource = resourceSet.createResource(uri);
		EObject eObject = null;
		try {
			java.lang.String s = jn.get("resourceType").textValue();
			log.trace("jnClass=" + s);
			Class<?> clazz = classFromName(s);
			eObject = (EObject) mapper.reader().withAttribute(EMFContext.Attributes.RESOURCE, resource).forType(clazz)
					.readValue(jn);
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eObject;
	}
	
//	static EObject loadRDF(InputStream reader, RDFFormat fmt) {
//		java.lang.String rdfFormat = java.lang.String.format("input.%s", fmt.getExtension());
//		URI uri = URI.createURI(rdfFormat);		
//		resource = resourceSet.createResource(uri);
//		try {
//			resource.load(reader, null);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		EList<EObject> eList = resource.getContents();
//		return eList.get(0);
//	}

	public static OutputStream save(EObject eObject, SDS_FORMAT format) {
		switch (format) {
		case XML:
			return saveXML(eObject);
		case JSON:
			return saveJSON(eObject);
		case ECORE:
			return saveECORE(eObject);
//		case RDF_TTL:
//			return saveRDF(eObject, RDFFormat.TURTLE);
//		case RDF_N3:
//			return saveRDF(eObject, RDFFormat.NTRIPLES);
		default:
			return null;
		}

	}

	static OutputStream saveXML(EObject eObject) {
		URI uri = assembleURI(Finals.SDS_FORMAT.XML);
		ByteArrayOutputStream writer = null;
		resource = resourceSet.createResource(uri);
		resource.getContents().add(eObject);
		try {
			writer = new ByteArrayOutputStream();
			Map<Object, Object> options = new HashMap<>();
			options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			options.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			options.put(XMLResource.OPTION_LINE_WIDTH, 80);
			options.put(XMLResource.OPTION_FORMATTED, Boolean.TRUE);  // 💡 Pretty-printing option
			resource.save(writer, options);
			writer.close();
		} catch (IOException e) {
			log.error("", e);
		}
		return writer;
	}

	static OutputStream saveJSON(EObject eObject) {
		URI uri = assembleURI(Finals.SDS_FORMAT.JSON);
		ByteArrayOutputStream writer = null;
		resource = resourceSet.createResource(uri);
		resource.getContents().add(eObject);

		try {
			writer = new ByteArrayOutputStream();
			java.lang.String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resource);
			writer.write(s.getBytes());
			writer.close();
			Map<Object, Object> options = new HashMap<>();
			options.put(SerializationFeature.INDENT_OUTPUT, Boolean.TRUE);	
			resource.save(writer, options);
		} catch (JsonProcessingException e) {
			log.error("", e);
		} catch (IOException e) {
			log.error("", e);
		}
		return writer;
	}

	static OutputStream saveECORE(EObject eObject) {
		URI uri = assembleURI(Finals.SDS_FORMAT.ECORE);
		ByteArrayOutputStream writer = null;
		resource = resourceSet.createResource(uri);
		resource.getContents().add(eObject);
		try {
			writer = new ByteArrayOutputStream();
			Map<Object, Object> options = new HashMap<>();
			options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
			options.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
			options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			options.put(XMLResource.OPTION_LINE_WIDTH, 80);
			options.put(XMLResource.OPTION_FORMATTED, Boolean.TRUE);  // 💡 Pretty-printing option
			resource.save(writer, options);
			writer.close();
		} catch (IOException e) {
			log.error("", e);
		}
		return writer;
	}

	public static Class<?> classFromName(java.lang.String resourceName) {
		try {
			return Class.forName(assembleFullName(resourceName));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	static URI assembleURI(SDS_FORMAT ext) {
		return URI.createURI(String.format("%s:///%s.%s",Finals.SCHEME, UUID.randomUUID().toString(), ext.getValue()));
//		return URI.createURI(Finals.SCHEME + ":///" + UUID.randomUUID().toString() + "." +  Finals.SDS_FORMAT.JSON);
	}

	static java.lang.String assembleFullName(java.lang.String resourceName) {
		return java.lang.String.format("%s.%s", Finals.FHIR_PACKAGE, resourceName);
	}
	
	public static void addEnumDeserializers() {
		module.addDeserializer(org.hl7.fhir.AccountStatus.class, new AccountStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ActionCardinalityBehavior.class, new ActionCardinalityBehaviorDeserializer());
		module.addDeserializer(org.hl7.fhir.ActionConditionKind.class, new ActionConditionKindDeserializer());
		module.addDeserializer(org.hl7.fhir.ActionGroupingBehavior.class, new ActionGroupingBehaviorDeserializer());
		module.addDeserializer(org.hl7.fhir.ActionParticipantType.class, new ActionParticipantTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ActionPrecheckBehavior.class, new ActionPrecheckBehaviorDeserializer());
		module.addDeserializer(org.hl7.fhir.ActionRelationshipType.class, new ActionRelationshipTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ActionRequiredBehavior.class, new ActionRequiredBehaviorDeserializer());
		module.addDeserializer(org.hl7.fhir.ActionSelectionBehavior.class, new ActionSelectionBehaviorDeserializer());
		module.addDeserializer(org.hl7.fhir.AddressType.class, new AddressTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.AddressUse.class, new AddressUseDeserializer());
		module.addDeserializer(org.hl7.fhir.AdministrativeGender.class, new AdministrativeGenderDeserializer());
		module.addDeserializer(org.hl7.fhir.AdverseEventActuality.class, new AdverseEventActualityDeserializer());
		module.addDeserializer(org.hl7.fhir.AgeUnits.class, new AgeUnitsDeserializer());
		module.addDeserializer(org.hl7.fhir.AggregationMode.class, new AggregationModeDeserializer());
		module.addDeserializer(org.hl7.fhir.AllergyIntoleranceCategory.class, new AllergyIntoleranceCategoryDeserializer());
		module.addDeserializer(org.hl7.fhir.AllergyIntoleranceCriticality.class, new AllergyIntoleranceCriticalityDeserializer());
		module.addDeserializer(org.hl7.fhir.AllergyIntoleranceSeverity.class, new AllergyIntoleranceSeverityDeserializer());
		module.addDeserializer(org.hl7.fhir.AllergyIntoleranceType.class, new AllergyIntoleranceTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.AppointmentStatus.class, new AppointmentStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.AssertionDirectionType.class, new AssertionDirectionTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.AssertionOperatorType.class, new AssertionOperatorTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.AssertionResponseTypes.class, new AssertionResponseTypesDeserializer());
		module.addDeserializer(org.hl7.fhir.AuditEventAction.class, new AuditEventActionDeserializer());
		module.addDeserializer(org.hl7.fhir.AuditEventAgentNetworkType.class, new AuditEventAgentNetworkTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.AuditEventOutcome.class, new AuditEventOutcomeDeserializer());
		module.addDeserializer(org.hl7.fhir.BindingStrength.class, new BindingStrengthDeserializer());
		module.addDeserializer(org.hl7.fhir.BiologicallyDerivedProductCategory.class, new BiologicallyDerivedProductCategoryDeserializer());
		module.addDeserializer(org.hl7.fhir.BiologicallyDerivedProductStatus.class, new BiologicallyDerivedProductStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.BiologicallyDerivedProductStorageScale.class, new BiologicallyDerivedProductStorageScaleDeserializer());
		module.addDeserializer(org.hl7.fhir.BundleType.class, new BundleTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.CapabilityStatementKind.class, new CapabilityStatementKindDeserializer());
		module.addDeserializer(org.hl7.fhir.CarePlanActivityKind.class, new CarePlanActivityKindDeserializer());
		module.addDeserializer(org.hl7.fhir.CarePlanActivityStatus.class, new CarePlanActivityStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.CarePlanIntent.class, new CarePlanIntentDeserializer());
		module.addDeserializer(org.hl7.fhir.CareTeamStatus.class, new CareTeamStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.CatalogEntryRelationType.class, new CatalogEntryRelationTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.CharacteristicCombination.class, new CharacteristicCombinationDeserializer());
		module.addDeserializer(org.hl7.fhir.ChargeItemStatus.class, new ChargeItemStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ClinicalImpressionStatus.class, new ClinicalImpressionStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ClinicalUseDefinitionType.class, new ClinicalUseDefinitionTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.CodeSearchSupport.class, new CodeSearchSupportDeserializer());
		module.addDeserializer(org.hl7.fhir.CodeSystemContentMode.class, new CodeSystemContentModeDeserializer());
		module.addDeserializer(org.hl7.fhir.CodeSystemHierarchyMeaning.class, new CodeSystemHierarchyMeaningDeserializer());
		module.addDeserializer(org.hl7.fhir.CompartmentType.class, new CompartmentTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.CompositionAttestationMode.class, new CompositionAttestationModeDeserializer());
		module.addDeserializer(org.hl7.fhir.CompositionStatus.class, new CompositionStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ConceptMapEquivalence.class, new ConceptMapEquivalenceDeserializer());
		module.addDeserializer(org.hl7.fhir.ConceptMapGroupUnmappedMode.class, new ConceptMapGroupUnmappedModeDeserializer());
		module.addDeserializer(org.hl7.fhir.ConditionalDeleteStatus.class, new ConditionalDeleteStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ConditionalReadStatus.class, new ConditionalReadStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.Confidentiality.class, new ConfidentialityDeserializer());
		module.addDeserializer(org.hl7.fhir.ConsentDataMeaning.class, new ConsentDataMeaningDeserializer());
		module.addDeserializer(org.hl7.fhir.ConsentProvisionType.class, new ConsentProvisionTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ConsentState.class, new ConsentStateDeserializer());
		module.addDeserializer(org.hl7.fhir.ConstraintSeverity.class, new ConstraintSeverityDeserializer());
		module.addDeserializer(org.hl7.fhir.ContactPointSystem.class, new ContactPointSystemDeserializer());
		module.addDeserializer(org.hl7.fhir.ContactPointUse.class, new ContactPointUseDeserializer());
		module.addDeserializer(org.hl7.fhir.ContractResourcePublicationStatusCodes.class, new ContractResourcePublicationStatusCodesDeserializer());
		module.addDeserializer(org.hl7.fhir.ContractResourceStatusCodes.class, new ContractResourceStatusCodesDeserializer());
		module.addDeserializer(org.hl7.fhir.ContributorType.class, new ContributorTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.CriteriaNotExistsBehavior.class, new CriteriaNotExistsBehaviorDeserializer());
		module.addDeserializer(org.hl7.fhir.DaysOfWeek.class, new DaysOfWeekDeserializer());
		module.addDeserializer(org.hl7.fhir.DefinitionResourceType.class, new DefinitionResourceTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.DetectedIssueSeverity.class, new DetectedIssueSeverityDeserializer());
		module.addDeserializer(org.hl7.fhir.DeviceMetricCalibrationState.class, new DeviceMetricCalibrationStateDeserializer());
		module.addDeserializer(org.hl7.fhir.DeviceMetricCalibrationType.class, new DeviceMetricCalibrationTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.DeviceMetricCategory.class, new DeviceMetricCategoryDeserializer());
		module.addDeserializer(org.hl7.fhir.DeviceMetricColor.class, new DeviceMetricColorDeserializer());
		module.addDeserializer(org.hl7.fhir.DeviceMetricOperationalStatus.class, new DeviceMetricOperationalStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.DeviceNameType.class, new DeviceNameTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.DeviceUseStatementStatus.class, new DeviceUseStatementStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.DiagnosticReportStatus.class, new DiagnosticReportStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.DiscriminatorType.class, new DiscriminatorTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.DocumentMode.class, new DocumentModeDeserializer());
		module.addDeserializer(org.hl7.fhir.DocumentReferenceStatus.class, new DocumentReferenceStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.DocumentRelationshipType.class, new DocumentRelationshipTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.EligibilityRequestPurpose.class, new EligibilityRequestPurposeDeserializer());
		module.addDeserializer(org.hl7.fhir.EligibilityResponsePurpose.class, new EligibilityResponsePurposeDeserializer());
		module.addDeserializer(org.hl7.fhir.EnableWhenBehavior.class, new EnableWhenBehaviorDeserializer());
		module.addDeserializer(org.hl7.fhir.EncounterLocationStatus.class, new EncounterLocationStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.EncounterStatus.class, new EncounterStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.EndpointStatus.class, new EndpointStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.EpisodeOfCareStatus.class, new EpisodeOfCareStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.EventCapabilityMode.class, new EventCapabilityModeDeserializer());
		module.addDeserializer(org.hl7.fhir.EventOrRequestResourceTypes.class, new EventOrRequestResourceTypesDeserializer());
		module.addDeserializer(org.hl7.fhir.EventResourceType.class, new EventResourceTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.EventStatus.class, new EventStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.EventTiming.class, new EventTimingDeserializer());
		module.addDeserializer(org.hl7.fhir.EvidenceVariableHandling.class, new EvidenceVariableHandlingDeserializer());
		module.addDeserializer(org.hl7.fhir.ExampleScenarioActorType.class, new ExampleScenarioActorTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ExplanationOfBenefitStatus.class, new ExplanationOfBenefitStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ExpressionLanguage.class, new ExpressionLanguageDeserializer());
		module.addDeserializer(org.hl7.fhir.ExtensionContextType.class, new ExtensionContextTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.FHIRAllTypes.class, new FHIRAllTypesDeserializer());
		module.addDeserializer(org.hl7.fhir.FHIRDefinedType.class, new FHIRDefinedTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.FHIRDeviceStatus.class, new FHIRDeviceStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.FHIRPathTypes.class, new FHIRPathTypesDeserializer());
		module.addDeserializer(org.hl7.fhir.FHIRSubstanceStatus.class, new FHIRSubstanceStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.FHIRVersion.class, new FHIRVersionDeserializer());
		module.addDeserializer(org.hl7.fhir.FamilyHistoryStatus.class, new FamilyHistoryStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.FilterOperator.class, new FilterOperatorDeserializer());
		module.addDeserializer(org.hl7.fhir.FinancialResourceStatusCodes.class, new FinancialResourceStatusCodesDeserializer());
		module.addDeserializer(org.hl7.fhir.FlagStatus.class, new FlagStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.GoalLifecycleStatus.class, new GoalLifecycleStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.GraphCompartmentRule.class, new GraphCompartmentRuleDeserializer());
		module.addDeserializer(org.hl7.fhir.GraphCompartmentUse.class, new GraphCompartmentUseDeserializer());
		module.addDeserializer(org.hl7.fhir.GroupMeasure.class, new GroupMeasureDeserializer());
		module.addDeserializer(org.hl7.fhir.GroupType.class, new GroupTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.GuidanceResponseStatus.class, new GuidanceResponseStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.GuidePageGeneration.class, new GuidePageGenerationDeserializer());
		module.addDeserializer(org.hl7.fhir.GuideParameterCode.class, new GuideParameterCodeDeserializer());
		module.addDeserializer(org.hl7.fhir.HTTPVerb.class, new HTTPVerbDeserializer());
		module.addDeserializer(org.hl7.fhir.IdentifierUse.class, new IdentifierUseDeserializer());
		module.addDeserializer(org.hl7.fhir.IdentityAssuranceLevel.class, new IdentityAssuranceLevelDeserializer());
		module.addDeserializer(org.hl7.fhir.ImagingStudyStatus.class, new ImagingStudyStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ImmunizationEvaluationStatusCodes.class, new ImmunizationEvaluationStatusCodesDeserializer());
		module.addDeserializer(org.hl7.fhir.ImmunizationStatusCodes.class, new ImmunizationStatusCodesDeserializer());
		module.addDeserializer(org.hl7.fhir.IngredientManufacturerRole.class, new IngredientManufacturerRoleDeserializer());
		module.addDeserializer(org.hl7.fhir.InteractionTrigger.class, new InteractionTriggerDeserializer());
		module.addDeserializer(org.hl7.fhir.InvoicePriceComponentType.class, new InvoicePriceComponentTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.InvoiceStatus.class, new InvoiceStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.IssueSeverity.class, new IssueSeverityDeserializer());
		module.addDeserializer(org.hl7.fhir.IssueType.class, new IssueTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.KnowledgeResourceType.class, new KnowledgeResourceTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.LinkType.class, new LinkTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.LinkageType.class, new LinkageTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ListMode.class, new ListModeDeserializer());
		module.addDeserializer(org.hl7.fhir.ListStatus.class, new ListStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.LocationMode.class, new LocationModeDeserializer());
		module.addDeserializer(org.hl7.fhir.LocationStatus.class, new LocationStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.MeasureReportStatus.class, new MeasureReportStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.MeasureReportType.class, new MeasureReportTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.MedicationRequestIntent.class, new MedicationRequestIntentDeserializer());
		module.addDeserializer(org.hl7.fhir.MedicationStatementStatusCodes.class, new MedicationStatementStatusCodesDeserializer());
		module.addDeserializer(org.hl7.fhir.MedicationStatusCodes.class, new MedicationStatusCodesDeserializer());
		module.addDeserializer(org.hl7.fhir.MedicationrequestStatus.class, new MedicationrequestStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.MessageSignificanceCategory.class, new MessageSignificanceCategoryDeserializer());
		module.addDeserializer(org.hl7.fhir.MessageheaderResponseRequest.class, new MessageheaderResponseRequestDeserializer());
		module.addDeserializer(org.hl7.fhir.NameUse.class, new NameUseDeserializer());
		module.addDeserializer(org.hl7.fhir.NamingSystemIdentifierType.class, new NamingSystemIdentifierTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.NamingSystemType.class, new NamingSystemTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.NarrativeStatus.class, new NarrativeStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.NoteType.class, new NoteTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.NutritionProductStatus.class, new NutritionProductStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ObservationDataType.class, new ObservationDataTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ObservationRangeCategory.class, new ObservationRangeCategoryDeserializer());
		module.addDeserializer(org.hl7.fhir.ObservationStatus.class, new ObservationStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.OperationKind.class, new OperationKindDeserializer());
		module.addDeserializer(org.hl7.fhir.OperationParameterUse.class, new OperationParameterUseDeserializer());
		module.addDeserializer(org.hl7.fhir.OrientationType.class, new OrientationTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ParticipantRequired.class, new ParticipantRequiredDeserializer());
		module.addDeserializer(org.hl7.fhir.ParticipationStatus.class, new ParticipationStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.PropertyRepresentation.class, new PropertyRepresentationDeserializer());
		module.addDeserializer(org.hl7.fhir.PropertyType.class, new PropertyTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ProvenanceEntityRole.class, new ProvenanceEntityRoleDeserializer());
		module.addDeserializer(org.hl7.fhir.PublicationStatus.class, new PublicationStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.QualityType.class, new QualityTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.QuantityComparator.class, new QuantityComparatorDeserializer());
		module.addDeserializer(org.hl7.fhir.QuestionnaireItemOperator.class, new QuestionnaireItemOperatorDeserializer());
		module.addDeserializer(org.hl7.fhir.QuestionnaireItemType.class, new QuestionnaireItemTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.QuestionnaireResponseStatus.class, new QuestionnaireResponseStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ReferenceHandlingPolicy.class, new ReferenceHandlingPolicyDeserializer());
		module.addDeserializer(org.hl7.fhir.ReferenceVersionRules.class, new ReferenceVersionRulesDeserializer());
		module.addDeserializer(org.hl7.fhir.RelatedArtifactType.class, new RelatedArtifactTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.RemittanceOutcome.class, new RemittanceOutcomeDeserializer());
		module.addDeserializer(org.hl7.fhir.ReportRelationshipType.class, new ReportRelationshipTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.RepositoryType.class, new RepositoryTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.RequestIntent.class, new RequestIntentDeserializer());
		module.addDeserializer(org.hl7.fhir.RequestPriority.class, new RequestPriorityDeserializer());
		module.addDeserializer(org.hl7.fhir.RequestResourceType.class, new RequestResourceTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.RequestStatus.class, new RequestStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ResearchElementType.class, new ResearchElementTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ResearchStudyStatus.class, new ResearchStudyStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ResearchSubjectStatus.class, new ResearchSubjectStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.ResourceType.class, new ResourceTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.ResourceVersionPolicy.class, new ResourceVersionPolicyDeserializer());
		module.addDeserializer(org.hl7.fhir.ResponseType.class, new ResponseTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.RestfulCapabilityMode.class, new RestfulCapabilityModeDeserializer());
		module.addDeserializer(org.hl7.fhir.SPDXLicense.class, new SPDXLicenseDeserializer());
		module.addDeserializer(org.hl7.fhir.SearchComparator.class, new SearchComparatorDeserializer());
		module.addDeserializer(org.hl7.fhir.SearchEntryMode.class, new SearchEntryModeDeserializer());
		module.addDeserializer(org.hl7.fhir.SearchModifierCode.class, new SearchModifierCodeDeserializer());
		module.addDeserializer(org.hl7.fhir.SearchParamType.class, new SearchParamTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.SequenceType.class, new SequenceTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.SlicingRules.class, new SlicingRulesDeserializer());
		module.addDeserializer(org.hl7.fhir.SlotStatus.class, new SlotStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.SortDirection.class, new SortDirectionDeserializer());
		module.addDeserializer(org.hl7.fhir.SpecimenContainedPreference.class, new SpecimenContainedPreferenceDeserializer());
		module.addDeserializer(org.hl7.fhir.SpecimenStatus.class, new SpecimenStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.Status.class, new StatusDeserializer());
		module.addDeserializer(org.hl7.fhir.StrandType.class, new StrandTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.StructureDefinitionKind.class, new StructureDefinitionKindDeserializer());
		module.addDeserializer(org.hl7.fhir.StructureMapContextType.class, new StructureMapContextTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.StructureMapGroupTypeMode.class, new StructureMapGroupTypeModeDeserializer());
		module.addDeserializer(org.hl7.fhir.StructureMapInputMode.class, new StructureMapInputModeDeserializer());
		module.addDeserializer(org.hl7.fhir.StructureMapModelMode.class, new StructureMapModelModeDeserializer());
		module.addDeserializer(org.hl7.fhir.StructureMapSourceListMode.class, new StructureMapSourceListModeDeserializer());
		module.addDeserializer(org.hl7.fhir.StructureMapTargetListMode.class, new StructureMapTargetListModeDeserializer());
		module.addDeserializer(org.hl7.fhir.StructureMapTransform.class, new StructureMapTransformDeserializer());
		module.addDeserializer(org.hl7.fhir.SubscriptionChannelType.class, new SubscriptionChannelTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.SubscriptionNotificationType.class, new SubscriptionNotificationTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.SubscriptionStatusCodes.class, new SubscriptionStatusCodesDeserializer());
		module.addDeserializer(org.hl7.fhir.SupplyDeliveryStatus.class, new SupplyDeliveryStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.SupplyRequestStatus.class, new SupplyRequestStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.SystemRestfulInteraction.class, new SystemRestfulInteractionDeserializer());
		module.addDeserializer(org.hl7.fhir.TaskIntent.class, new TaskIntentDeserializer());
		module.addDeserializer(org.hl7.fhir.TaskStatus.class, new TaskStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.TestReportActionResult.class, new TestReportActionResultDeserializer());
		module.addDeserializer(org.hl7.fhir.TestReportParticipantType.class, new TestReportParticipantTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.TestReportResult.class, new TestReportResultDeserializer());
		module.addDeserializer(org.hl7.fhir.TestReportStatus.class, new TestReportStatusDeserializer());
		module.addDeserializer(org.hl7.fhir.TestScriptRequestMethodCode.class, new TestScriptRequestMethodCodeDeserializer());
		module.addDeserializer(org.hl7.fhir.TriggerType.class, new TriggerTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.TypeDerivationRule.class, new TypeDerivationRuleDeserializer());
		module.addDeserializer(org.hl7.fhir.TypeRestfulInteraction.class, new TypeRestfulInteractionDeserializer());
		module.addDeserializer(org.hl7.fhir.UDIEntryType.class, new UDIEntryTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.UnitsOfTime.class, new UnitsOfTimeDeserializer());
		module.addDeserializer(org.hl7.fhir.Use.class, new UseDeserializer());
		module.addDeserializer(org.hl7.fhir.VariableType.class, new VariableTypeDeserializer());
		module.addDeserializer(org.hl7.fhir.VisionBase.class, new VisionBaseDeserializer());
		module.addDeserializer(org.hl7.fhir.VisionEyes.class, new VisionEyesDeserializer());
		module.addDeserializer(org.hl7.fhir.XPathUsageType.class, new XPathUsageTypeDeserializer());
	}	
	
	public static void main(String[] args) {
		FHIRSerDeser app = new FHIRSerDeser();
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}
}
