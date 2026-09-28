package api;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    public static Response get(String endpoint)
    {
        return given()
        .spec(APIRequestSpec.getRequestSpec())
        .when()
        .get(endpoint);
    }

    public static Response post(String endpoint,Object requestBody)
    {
        return given()
        .spec(APIRequestSpec.getRequestSpec())
        .body(requestBody)
        .when()
        .post(endpoint);
    }

    public static Response put(String endpoint,Object requestBody)
    {
        return given()
        .spec(APIRequestSpec.getRequestSpec())
        .body(requestBody)
        .when()
        .put(endpoint);
    }

     public static Response patch(String endpoint,Object requestBody)
    {
        return given()
        .spec(APIRequestSpec.getRequestSpec())
        .body(requestBody)
        .when()
        .patch(endpoint);
    }

     public static Response delete(String endpoint)
    {
        return given()
        .spec(APIRequestSpec.getRequestSpec())
        .when()
        .delete(endpoint);
    }


}
