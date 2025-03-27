#!/usr/bin/env bash

clear; 
./gradlew clean :test --tests org.hl7.fhir.emf.FHIRSerDeserTest.testAssembleURI
