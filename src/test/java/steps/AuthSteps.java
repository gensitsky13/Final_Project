package steps;

import com.codeborne.selenide.Selenide;
import di.TestContext;
import helpers.UserDataGenerator;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
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
private final TestContext testContext;
public AuthSteps(TestContext testContext){
    this.testContext = testContext;
}
   /* @Дано("создан новый пользователь")
    public void createUser() {
        User user = UserDataGenerator.generateUser();
        testContext.setCurrentUser(user);
    }


    */

@Когда("существующий пользователь зарегистрирован через API")
public void existingUserRegisteredViaApi() {
    //User user = new User(
           // "gens" + System.currentTimeMillis() + "@gmail.com",
           // "olga123@!"
    User user = testContext.getCurrentUser();

    //userApi.register(user);


   // TestContext.setUser(user);
    Response response = userApi.register(user);
    assertTrue(response.statusCode() == 201 || response.statusCode() == 200);
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