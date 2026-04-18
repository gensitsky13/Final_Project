package steps;
import api.ApiClient;
import api.UserApi;
import com.codeborne.selenide.Selenide;
import di.TestContext;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import helpers.UserDataGenerator;
import models.User;
import pages.LoginPage;
import pages.RegisterPage;
import static com.codeborne.selenide.Selenide.open;



public class RegistrationSteps {

    private final RegisterPage registerPage = new RegisterPage();
    private final TestContext testContext;

    public RegistrationSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Дано("открыт экран регистрации")
    public void openRegistrationScreen() {
        LoginPage.goToRegistration();
    }


    @Когда("пользователь регистрируется через UI с уникальными данными")
    public void registerUserViaUiWithUniqueData() {
        User user= testContext.getCurrentUser();
        registerPage.fillRegistrationForm(user.getEmail(),user.getPassword());
        registerPage.submitRegistration();
    }

    @Тогда("регистрация успешна")
    public void verifyRegistrationSuccess() {
        registerPage.checkRegistrationSuccess();
    }
    @И("пользователь закрывает браузер")
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
    @Дано("пользователь открывает экран регистрации")
    public void openRegistrationPage() {
open("https://qa-desk.stand.praktikum-services.ru/registration");

    }
    @Дано("создан новый пользователь")
    public void createNewUser() {
        User user = UserDataGenerator.generateUser();
        testContext.setCurrentUser(user);
    }
    @Дано("пользователь зарегистрирован через API")
    public void userRegisteredViaApi() {
        User user = UserDataGenerator.generateUser();

        ApiClient client = new ApiClient();
        UserApi userApi = new UserApi(client);

        userApi.register(user);

        testContext.setCurrentUser(user);
    }

    @Когда("пользователь пытается зарегистрироваться повторно через UI тем же email")
    public void tryToRegisterAgainWithSameEmail() {
       // String email = "gens@gmail.com";
       // String password = "olga123@!";
        User user = testContext.getCurrentUser();
        registerPage.fillRegistrationForm(user.getEmail(),user.getPassword());
        registerPage.submitRegistration();
    }

    @Тогда("пользователь видит ошибку что email уже существует")
    public void verifyDuplicateEmailError() {
        registerPage.shouldSeeDuplicateEmailError();
    }
}