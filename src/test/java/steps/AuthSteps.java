package steps;

import di.TestContext;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import models.User;
import pages.AdsPage;
import pages.LoginPage;
import pages.MainPage;

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
private final TestContext testContext;
public AuthSteps(TestContext testContext){
    this.testContext = testContext;
}

@Когда("существующий пользователь зарегистрирован через API")
public void existingUserRegisteredViaApi() {

    User user = testContext.getCurrentUser();


}
    @Когда("пользователь авторизуется")
    public void logInUser() {
        User user = testContext.getCurrentUser();
        loginPage.login(user.getEmail(), user.getPassword());
    }

    @Когда("пользователь авторизуется как ранее зарегистрированный")
    public void logInAsPreviouslyRegisteredUser() {
    User user = testContext.getCurrentUser();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.shouldBeLoggedIn();
    }

    @Тогда("пользователь успешно авторизован")
    public void verifyUserIsLoggedIn() {
        assertTrue(testContext.getCurrentUser() != null);
    }
}