package steps;

import di.TestContext;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import models.User;
import pages.AdsPage;
import pages.LoginPage;
import pages.MainPage;
import utils.TestData;
import api.ApiClient;
import api.UserApi;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthSteps {


private static final TestContext context = new TestContext();
private LoginPage loginPage = new LoginPage();
private final AdsPage adsPage = new AdsPage();
private final ApiClient apiClient = new ApiClient();
private final UserApi userApi = new UserApi(apiClient);
private final MainPage mainPage = new MainPage();


/*@Когда("существующий пользователь зарегистрирован через API")
public void existingUserRegisteredViaApi() {
    User user = TestData.validUser();
    TestContext.setUser(user);

    Response response = userApi.register(user);
    assertTrue(response.statusCode() == 201 || response.statusCode() == 200);
}

 */
@Когда("существующий пользователь зарегистрирован через API")
public void existingUserRegisteredViaApi() {
    User user = new User(
            "test" + System.currentTimeMillis() + "@yandex.ru",
            "123456"
    );

    TestContext.setUser(user);

    Response response = userApi.register(user);
    System.out.println("STATUS: " + response.statusCode());
    System.out.println("BODY: " + response.getBody().asString());

    assertTrue(response.statusCode() == 201 || response.statusCode() == 200);
}
    @Когда("пользователь авторизуется")
    public void пользователь_авторизуется() {
        User user = TestContext.getUser();
        loginPage.login(user.getEmail(), user.getPassword());
    }
    @Когда("пользователь авторизуется как ранее зарегистрированный")
    public void пользователь_авторизуется_как_ранее_зарегистрированный() {
    User user = TestContext.getUser();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.shouldBeLoggedIn();
    }

    @Тогда("пользователь успешно авторизован")
    public void пользователь_успешно_авторизован() {
        assertTrue(TestContext.getUser() != null);
    }
}