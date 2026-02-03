package api;

import config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    public RequestSpecification baseSpec() {
        return RestAssured.given()
                .baseUri(TestConfig.API_BASE_URL)
                .contentType("application/json");
    }
}
