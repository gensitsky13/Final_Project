package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.LoginPage;
import pages.RegisterPage;

public class RegistrationSteps {

    private final LoginPage loginPage;
    private RegisterPage registerPage;

    private String email;
    private String password;

    public RegistrationSteps() {
        this.loginPage = new LoginPage();
    }

    @Дано("открыт экран регистрации")
    public void открыть_экран_регистрации() {
        registerPage = loginPage.goToRegistration();
    }

    @Когда("пользователь регистрируется через UI с уникальными данными")
    public void пользователь_регистрируется_через_ui_с_уникальными_данными() {
        email = "test" + System.currentTimeMillis() + "@gmail.com";
        password = "123456";

        registerPage.fillRegistrationForm(email, password);
        registerPage.submitRegistration();
    }

    @Тогда("регистрация успешна")
    public void регистрация_успешна() {
        registerPage.checkRegistrationSuccess();
    }

    @Когда("пользователь пытается зарегистрироваться повторно через UI тем же email")
    public void пользователь_пытается_зарегистрироваться_повторно_через_ui_тем_же_email() {
        registerPage.fillRegistrationForm(email, password);
        registerPage.submitRegistration();
    }

    @Тогда("пользователь видит ошибку что email уже существует")
    public void пользователь_видит_ошибку_что_email_уже_существует() {
        registerPage.shouldSeeDuplicateEmailError();
    }
}