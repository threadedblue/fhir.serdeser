package org.hl7.fhir.emf;

import java.lang.String;

import org.hl7.fhir.*;
import org.hl7.fhir.util.FhirSwitch;

//
// Returns the value desired of an entity as a string.
// This is like a special implementation of toString but for EObjects.
//
public class SDSSwitch extends FhirSwitch<String> {

	@Override
	public String caseId(Id n) {
		return n.getValue();
	}
	
	@Override
	public String caseString(org.hl7.fhir.String s) {
		return s.getValue();
	}

	// Enum cases
    @Override
    public String caseSlicingRules(SlicingRules e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseGraphCompartmentUse(GraphCompartmentUse e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStructureMapContextType(StructureMapContextType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDeviceNameType(DeviceNameType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseMeasureReportType(MeasureReportType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAddressUse(AddressUse e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEndpointStatus(EndpointStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTriggerType(TriggerType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseRequestStatus(RequestStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStrandType(StrandType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDeviceMetricCalibrationState(DeviceMetricCalibrationState e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEventOrRequestResourceTypes(EventOrRequestResourceTypes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDiscriminatorType(DiscriminatorType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEventResourceType(EventResourceType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDefinitionResourceType(DefinitionResourceType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFlagStatus(FlagStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseInteractionTrigger(InteractionTrigger e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseOrientationType(OrientationType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseParticipantRequired(ParticipantRequired e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseActionGroupingBehavior(ActionGroupingBehavior e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDaysOfWeek(DaysOfWeek e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseVisionEyes(VisionEyes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEvidenceVariableHandling(EvidenceVariableHandling e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseIdentityAssuranceLevel(IdentityAssuranceLevel e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseBundleType(BundleType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseNameUse(NameUse e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSystemRestfulInteraction(SystemRestfulInteraction e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseQuestionnaireItemType(QuestionnaireItemType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String casePropertyType(PropertyType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseResearchElementType(ResearchElementType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAuditEventAgentNetworkType(AuditEventAgentNetworkType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAllergyIntoleranceCategory(AllergyIntoleranceCategory e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEventStatus(EventStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTestReportActionResult(TestReportActionResult e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseGuidanceResponseStatus(GuidanceResponseStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStructureDefinitionKind(StructureDefinitionKind e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseOperationKind(OperationKind e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConditionalReadStatus(ConditionalReadStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCodeSearchSupport(CodeSearchSupport e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFamilyHistoryStatus(FamilyHistoryStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSpecimenContainedPreference(SpecimenContainedPreference e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseNoteType(NoteType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSubscriptionStatusCodes(SubscriptionStatusCodes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseRemittanceOutcome(RemittanceOutcome e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String casePublicationStatus(PublicationStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseContributorType(ContributorType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseObservationStatus(ObservationStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseGroupMeasure(GroupMeasure e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSlotStatus(SlotStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseBiologicallyDerivedProductStorageScale(BiologicallyDerivedProductStorageScale e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseObservationDataType(ObservationDataType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAppointmentStatus(AppointmentStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseKnowledgeResourceType(KnowledgeResourceType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseMessageSignificanceCategory(MessageSignificanceCategory e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseImmunizationStatusCodes(ImmunizationStatusCodes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseLocationStatus(LocationStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDocumentReferenceStatus(DocumentReferenceStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTestReportStatus(TestReportStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStructureMapTransform(StructureMapTransform e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseNamingSystemType(NamingSystemType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTaskStatus(TaskStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConstraintSeverity(ConstraintSeverity e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseOperationParameterUse(OperationParameterUse e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCodeSystemContentMode(CodeSystemContentMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConfidentiality(Confidentiality e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseListStatus(ListStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEncounterLocationStatus(EncounterLocationStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseQualityType(QualityType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseActionConditionKind(ActionConditionKind e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseParticipationStatus(ParticipationStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseUnitsOfTime(UnitsOfTime e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAssertionOperatorType(AssertionOperatorType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseRestfulCapabilityMode(RestfulCapabilityMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseActionCardinalityBehavior(ActionCardinalityBehavior e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseGuidePageGeneration(GuidePageGeneration e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDiagnosticReportStatus(DiagnosticReportStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSortDirection(SortDirection e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTestScriptRequestMethodCode(TestScriptRequestMethodCode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseMedicationRequestIntent(MedicationRequestIntent e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFHIRPathTypes(FHIRPathTypes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseInvoiceStatus(InvoiceStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSubscriptionChannelType(SubscriptionChannelType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseQuestionnaireItemOperator(QuestionnaireItemOperator e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAuditEventAction(AuditEventAction e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCapabilityStatementKind(CapabilityStatementKind e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseInvoicePriceComponentType(InvoicePriceComponentType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseNutritionProductStatus(NutritionProductStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCompartmentType(CompartmentType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseResearchSubjectStatus(ResearchSubjectStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseRequestPriority(RequestPriority e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSubscriptionNotificationType(SubscriptionNotificationType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAgeUnits(AgeUnits e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseActionSelectionBehavior(ActionSelectionBehavior e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseIngredientManufacturerRole(IngredientManufacturerRole e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSPDXLicense(SPDXLicense e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCriteriaNotExistsBehavior(CriteriaNotExistsBehavior e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseImagingStudyStatus(ImagingStudyStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSpecimenStatus(SpecimenStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseBindingStrength(BindingStrength e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDeviceMetricOperationalStatus(DeviceMetricOperationalStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseVisionBase(VisionBase e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSearchModifierCode(SearchModifierCode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseMedicationStatementStatusCodes(MedicationStatementStatusCodes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseUse(Use e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseNarrativeStatus(NarrativeStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAssertionDirectionType(AssertionDirectionType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSupplyRequestStatus(SupplyRequestStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCharacteristicCombination(CharacteristicCombination e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFHIRDefinedType(FHIRDefinedType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCodeSystemHierarchyMeaning(CodeSystemHierarchyMeaning e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseRepositoryType(RepositoryType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTestReportResult(TestReportResult e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseGraphCompartmentRule(GraphCompartmentRule e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDetectedIssueSeverity(DetectedIssueSeverity e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFHIRAllTypes(FHIRAllTypes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String casePropertyRepresentation(PropertyRepresentation e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDocumentMode(DocumentMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseExpressionLanguage(ExpressionLanguage e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseListMode(ListMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseIssueType(IssueType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseGoalLifecycleStatus(GoalLifecycleStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSearchParamType(SearchParamType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFHIRVersion(FHIRVersion e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseReferenceHandlingPolicy(ReferenceHandlingPolicy e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFHIRSubstanceStatus(FHIRSubstanceStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseClinicalImpressionStatus(ClinicalImpressionStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStructureMapSourceListMode(StructureMapSourceListMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCatalogEntryRelationType(CatalogEntryRelationType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDeviceMetricCategory(DeviceMetricCategory e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAggregationMode(AggregationMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseContractResourceStatusCodes(ContractResourceStatusCodes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseActionRequiredBehavior(ActionRequiredBehavior e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseObservationRangeCategory(ObservationRangeCategory e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTypeDerivationRule(TypeDerivationRule e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAllergyIntoleranceCriticality(AllergyIntoleranceCriticality e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEligibilityRequestPurpose(EligibilityRequestPurpose e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTypeRestfulInteraction(TypeRestfulInteraction e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseProvenanceEntityRole(ProvenanceEntityRole e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseHTTPVerb(HTTPVerb e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseChargeItemStatus(ChargeItemStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCarePlanActivityStatus(CarePlanActivityStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSequenceType(SequenceType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseIssueSeverity(IssueSeverity e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConsentState(ConsentState e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseUDIEntryType(UDIEntryType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStructureMapGroupTypeMode(StructureMapGroupTypeMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseContractResourcePublicationStatusCodes(ContractResourcePublicationStatusCodes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseReportRelationshipType(ReportRelationshipType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCarePlanActivityKind(CarePlanActivityKind e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSearchEntryMode(SearchEntryMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEpisodeOfCareStatus(EpisodeOfCareStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseImmunizationEvaluationStatusCodes(ImmunizationEvaluationStatusCodes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseExampleScenarioActorType(ExampleScenarioActorType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseMedicationrequestStatus(MedicationrequestStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseResourceType(ResourceType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseRequestResourceType(RequestResourceType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseResponseType(ResponseType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEligibilityResponsePurpose(EligibilityResponsePurpose e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseContactPointSystem(ContactPointSystem e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseIdentifierUse(IdentifierUse e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseQuestionnaireResponseStatus(QuestionnaireResponseStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConceptMapGroupUnmappedMode(ConceptMapGroupUnmappedMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCompositionStatus(CompositionStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseMessageheaderResponseRequest(MessageheaderResponseRequest e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseClinicalUseDefinitionType(ClinicalUseDefinitionType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAuditEventOutcome(AuditEventOutcome e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStructureMapInputMode(StructureMapInputMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseResearchStudyStatus(ResearchStudyStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEnableWhenBehavior(EnableWhenBehavior e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConsentProvisionType(ConsentProvisionType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDeviceMetricCalibrationType(DeviceMetricCalibrationType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSupplyDeliveryStatus(SupplyDeliveryStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTaskIntent(TaskIntent e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStructureMapTargetListMode(StructureMapTargetListMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseBiologicallyDerivedProductStatus(BiologicallyDerivedProductStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseSearchComparator(SearchComparator e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseExplanationOfBenefitStatus(ExplanationOfBenefitStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseReferenceVersionRules(ReferenceVersionRules e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAdverseEventActuality(AdverseEventActuality e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDeviceUseStatementStatus(DeviceUseStatementStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAddressType(AddressType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseQuantityComparator(QuantityComparator e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseXPathUsageType(XPathUsageType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseActionPrecheckBehavior(ActionPrecheckBehavior e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseGuideParameterCode(GuideParameterCode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEncounterStatus(EncounterStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseActionRelationshipType(ActionRelationshipType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseLocationMode(LocationMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAccountStatus(AccountStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseExtensionContextType(ExtensionContextType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFinancialResourceStatusCodes(FinancialResourceStatusCodes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseActionParticipantType(ActionParticipantType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConditionalDeleteStatus(ConditionalDeleteStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseLinkageType(LinkageType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConceptMapEquivalence(ConceptMapEquivalence e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCareTeamStatus(CareTeamStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseTestReportParticipantType(TestReportParticipantType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseVariableType(VariableType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCarePlanIntent(CarePlanIntent e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEventCapabilityMode(EventCapabilityMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseEventTiming(EventTiming e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseGroupType(GroupType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseCompositionAttestationMode(CompositionAttestationMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseRelatedArtifactType(RelatedArtifactType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAdministrativeGender(AdministrativeGender e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStatus(Status e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseContactPointUse(ContactPointUse e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAssertionResponseTypes(AssertionResponseTypes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseConsentDataMeaning(ConsentDataMeaning e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseResourceVersionPolicy(ResourceVersionPolicy e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFHIRDeviceStatus(FHIRDeviceStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAllergyIntoleranceSeverity(AllergyIntoleranceSeverity e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseMeasureReportStatus(MeasureReportStatus e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseBiologicallyDerivedProductCategory(BiologicallyDerivedProductCategory e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseLinkType(LinkType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseNamingSystemIdentifierType(NamingSystemIdentifierType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseMedicationStatusCodes(MedicationStatusCodes e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDeviceMetricColor(DeviceMetricColor e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseDocumentRelationshipType(DocumentRelationshipType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseFilterOperator(FilterOperator e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseStructureMapModelMode(StructureMapModelMode e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseAllergyIntoleranceType(AllergyIntoleranceType e) {
        return e.getValue().getLiteral();
    }

    @Override
    public String caseRequestIntent(RequestIntent e) {
        return e.getValue().getLiteral();
    }

//	
//	@Override
//	public String defaultCase(EObject object) {
//		return "";
//	}
}
