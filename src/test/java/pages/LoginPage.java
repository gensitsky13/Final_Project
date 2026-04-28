package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.disappear;

public class LoginPage extends BasePage {

    private static final SelenideElement openLoginPopupButton = $(byText("Вход и регистрация"));
    private static final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement loginSubmitButton = $(".buttonPrimary[type='submit']");
    private static final SelenideElement registerLink = $(byText("Нет аккаунта"));
    private static final SelenideElement registerTitle = $(byText("Зарегистрироваться"));
    private final SelenideElement createAdButton = $(byText("Разместить объявление"));
    private final SelenideElement loginPopup = $("div.homePage_modal");


    public static void openLoginPopup() {
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

    public static RegisterPage goToRegistration() {
        openLoginPopup();
        registerLink.shouldBe(visible).click();
        registerTitle.should(appear);
        RegisterPage registerPage = new RegisterPage();
        registerPage.shouldBeOpened();
        return registerPage;
    }
}