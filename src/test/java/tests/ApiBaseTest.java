package tests;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class ApiBaseTest {
    
    @BeforeSuite 
    public void setUp()
    {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
