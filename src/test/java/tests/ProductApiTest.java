package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import api.ProductApi;
import io.restassured.response.Response;
import listeners.TestListener;
import utils.ReportUtils;
import utils.SchemaValidator;
import static org.hamcrest.Matchers.*;

@Listeners(TestListener.class)
public class ProductApiTest extends ApiBaseTest{
    @Test 
    public void getAllProducts()
    {
        ReportUtils.info("Start Get All Products test");
        ProductApi productApi = new ProductApi();

        ReportUtils.info("Send GET request to retrieve all products");
        Response response = productApi.getRecords();
        response.then()
        .statusCode(200)
        .body("data.size()",greaterThan(0));

        ReportUtils.info("Validate response schema");
        SchemaValidator.validate(response.asString(), "schemas/AllProductsSchema.json");

    }
}
