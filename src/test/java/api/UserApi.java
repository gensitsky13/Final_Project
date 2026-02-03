package api;

import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

public class UserApi {
    private final ApiClient client;

    public UserApi(ApiClient client) {
        this.client = client;
    }

    public Response register(User user) {

        String body = String.format(
                "{\"email\":\"%s\",\"password\":\"%s\",\"submitPassword\":\"%s\"}",
                user.getEmail(),
                user.getPassword(),
                user.getPassword()
        );

        return given()
                .spec(client.baseSpec())
                .body(body)
                .when()
                .post("/api/signup");
    }

}

