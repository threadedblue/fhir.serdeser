package org.hl7.fhir.emf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class Validations {
	
	private static final Logger LOG = LoggerFactory.getLogger(Validations.class);
	
	//@Test
	public void givenInvalidInput_whenValidating_thenInvalid1() throws ValidationException {
		InputStream readerSchema = null;
		InputStream readerSubject = null;
		try {
			readerSchema = new FileInputStream("model/fhir.schema.json");
			readerSubject = new FileInputStream("data/org-out.json");
			JSONObject jsonSchema = new JSONObject(new JSONTokener(readerSchema));
			JSONObject jsonSubject = new JSONObject(new JSONTokener(readerSubject));
			Schema schema = SchemaLoader.load(jsonSchema);
			schema.validate(jsonSubject);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

@Test
public void givenInvalidInput_whenValidating_thenInvalid2() {
	InputStream readerSchema = null;
	InputStream readerSubject = null;
    ObjectMapper objectMapper = new ObjectMapper();  
    JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance( SpecVersion.VersionFlag.V6 );  
	try {
		readerSchema = new FileInputStream("model/fhir.schema.json");
		readerSubject = new FileInputStream("data/org-out.json");
		JsonSchema schema = schemaFactory.getSchema(readerSchema);  
		JsonNode json = objectMapper.readTree(readerSubject);  
		Set<ValidationMessage> validationResult = schema.validate( json );  
		if (validationResult.isEmpty()) {  
			LOG.info("valid");
		} else {
			 validationResult.forEach(vm -> LOG.info(vm.getMessage())); 
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	 
}

}