package api;

import io.restassured.response.Response;

public class ProductApi {
    public Response getRecords()
    {
        return ApiClient.get("/collections/products/records?project_id=52219");
    }

    public Response getUser(String endpoint)
    {
        return ApiClient.get("/collections/products/records/"+endpoint);
    }

    public Response createRecord(Object body)
    {
        return ApiClient.post("https://reqres.in/api/collections/products/records?project_id=52219",body);
    }

    public Response updateRecord(String endpoint , Object body)
    {
        return ApiClient.post("https://reqres.in/api/collections/products/"+endpoint,body);
    }

    public Response deleteRecord(String endpoint)
    {
        return ApiClient.delete("https://reqres.in/api/collections/products/"+endpoint);
    }
}
