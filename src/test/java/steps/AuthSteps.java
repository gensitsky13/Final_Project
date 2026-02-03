package steps;

import di.TestContext;
import io.cucumber.java.ru.Когда;
import io.restassured.response.Response;
import models.User;
import utils.TestData;
import api.ApiClient;
import api.UserApi;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthSteps {

    private static final TestContext context = new TestContext();
    private final ApiClient apiClient = new ApiClient();
    private final UserApi userApi = new UserApi(apiClient);

    @Когда("существующий пользователь зарегистрирован через API")
    public void existingUserRegisteredViaApi() {
        User user = TestData.validUser();
        context.setUser(user);

        Response response = userApi.register(user);
        assertTrue(response.statusCode() == 201 || response.statusCode() == 200);
    }
}