package steps;

import di.TestContext;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import models.User;
import org.example.Main;
import pages.MainPage;
import pages.RegisterPage;
import utils.TestData;

public class RegistrationSteps {

    private final RegisterPage registerPage = new RegisterPage();
    private static final TestContext context = new TestContext();

    @Когда("пользователь регистрируется через UI с уникальными данными")
    public void registerUniqueUserViaUi() {
        User user = TestData.validUser();
        context.setUser(user);

        registerPage.registerSuccessfully(user.getEmail(), user.getPassword());
    }

    @Когда("пользователь пытается зарегистрироваться повторно через UI тем же email")
    public void registerSameEmailAgainViaUi() {
        // ❗ НИЧЕГО не заполняем
//        registerPage.submitDuplicateRegistration();
        User user = context.getUser();
        registerPage.registerSuccessfully(user.getEmail(), user.getPassword());
    }


    @Тогда("пользователь видит ошибку что email уже существует")
    public void userSeesDuplicateEmailError() {
        User user = context.getUser();
        //registerPage.registerSuccessfully(user.getEmail(), user.getPassword());
        registerPage.shouldSeeDuplicateEmailError();
    }

    @Когда("открыт экран registracii")
    public void showRegistrationPage() {
        new MainPage().showRegistration();
    }
}

