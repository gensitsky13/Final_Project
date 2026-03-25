package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage extends BasePage {

    private final SelenideElement emailInput = $("input[placeholder='Введите Email']");
    private final SelenideElement passwordInput = $("input[placeholder='Пароль']");
    private final SelenideElement repeatPasswordInput = $("input[placeholder='Повторите пароль']");
    private final SelenideElement submitButton = $(byText("Создать аккаунт"));
    private final SelenideElement loginButtonInRegisterPopup = $(byText("Уже есть аккаунт"));
    private final SelenideElement registerTitle = $(byText("Зарегистрироваться"));
    private final SelenideElement validationError = $(byText("Ошибка"));

    public void shouldBeOpened() {
        registerTitle.shouldBe(visible);
        emailInput.shouldBe(visible);
    }

    public void fillRegistrationForm(String email, String password) {
        emailInput.shouldBe(visible).setValue(email);
        passwordInput.shouldBe(visible).setValue(password);
        repeatPasswordInput.shouldBe(visible).setValue(password);
    }

    public void submitRegistration() {
        submitButton.shouldBe(visible).shouldBe(enabled).click();
    }

    public void shouldSeeDuplicateEmailError() {
       registerTitle.shouldBe(visible);
       validationError.shouldBe(visible);
    }

    public void checkRegistrationSuccess() {
        loginButtonInRegisterPopup.shouldBe(visible);
    }
}