package api;

import api.dto.RegisterRequest;
import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

public class UserApi {

    private final ApiClient client;

    public UserApi(ApiClient client) {
        this.client = client;
    }

    public Response register(User user) {
        RegisterRequest body =
                new RegisterRequest(user.getEmail(), user.getPassword());

        return given()
                .spec(client.baseSpec())
                .body(body)
                .when()
                .post("/api/signup");
    }
}