package steps;
import com.codeborne.selenide.Selenide;
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

    private RegisterPage registerPage;
    private User user = UserDataGenerator.generateUser();

    @Дано("открыт экран регистрации")
    public void openRegistrationScreen() {
        registerPage = LoginPage.goToRegistration();
    }

    @Когда("пользователь регистрируется через UI с уникальными данными")
    public void registerUserViaUiWithUniqueData() {
        registerPage.fillRegistrationForm(user.getEmail(), user.getPassword());
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




    @Когда("пользователь пытается зарегистрироваться повторно через UI тем же email")
    public void tryToRegisterAgainWithSameEmail() {
        String email = "gens@gmail.com";
        String password = "olga123@!";
        registerPage.fillRegistrationForm(email,password);
        registerPage.submitRegistration();
    }

    @Тогда("пользователь видит ошибку что email уже существует")
    public void verifyDuplicateEmailError() {
        registerPage.shouldSeeDuplicateEmailError();
    }
}