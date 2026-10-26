package api;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class APIRequestSpec {
    
    
    public static RequestSpecification getRequestSpec()
    {
        String apiKey = System.getenv("API_KEY");
        return new RequestSpecBuilder()
        .setBaseUri(ConfigReader.get("api.Url"))
        .setContentType("application/json")
        .addHeader("x-api-key", apiKey)
        .build();
    }
}