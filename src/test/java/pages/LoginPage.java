package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.disappear;

public class LoginPage extends BasePage {

    private final SelenideElement openLoginPopupButton = $(byText("Вход и регистрация"));
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement loginSubmitButton = $(".buttonPrimary[type='submit']");
    private final SelenideElement registerLink = $(byText("Нет аккаунта"));
    private final SelenideElement registerTitle = $(byText("Зарегистрироваться"));
    private final SelenideElement createAdButton = $(byText("Разместить объявление"));
    private final SelenideElement loginPopup = $("div.homePage_modal");


    public void openLoginPopup() {
        openLoginPopupButton.shouldBe(visible).shouldBe(enabled).click();
        emailInput.should(appear);
    }

    public void login(String email, String password) {
        openLoginPopup();

        emailInput.shouldBe(visible).click();
        emailInput.setValue(email);

        passwordInput.shouldBe(visible).click();
        passwordInput.setValue(password);
        passwordInput.pressTab();

        loginSubmitButton.shouldBe(visible).click();
loginPopup.shouldBe(disappear);
        createAdButton.shouldBe(visible);
    }

    public RegisterPage goToRegistration() {
        openLoginPopup();
        registerLink.shouldBe(visible).click();
        registerTitle.should(appear);
        RegisterPage registerPage = new RegisterPage();
        registerPage.shouldBeOpened();
        return registerPage;
    }
}