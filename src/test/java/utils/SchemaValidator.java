package utils;

import java.io.InputStream;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class SchemaValidator {
    
    public static final ObjectMapper mapper=new ObjectMapper();

    public static void validate(String response, String schemaFile)
    {
        try{
            //Convert API response to json
           JsonNode jsonResponse = mapper.readTree(response);

           //Read schema from src/test/resources
           InputStream schemaStream = SchemaValidator.class.getClassLoader().getResourceAsStream(schemaFile);

           if (schemaStream == null) {
                throw new RuntimeException("Schema file not found: " + schemaFile);
            }

            JsonSchemaFactory factory= JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema schema=factory.getSchema(schemaStream);

            //Validate Response
            Set<ValidationMessage> errors = schema.validate(jsonResponse);
            if(!errors.isEmpty())
            {
                 StringBuilder message = new StringBuilder("JSON Schema Validation failed:\n");
                for(ValidationMessage error:errors)
                {
                    message.append(error.getMessage()).append("\n");
                }
                throw new AssertionError(message.toString());
            }
            ReportUtils.info("JSON Schema Validation passed");
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
       
       
    }

}
