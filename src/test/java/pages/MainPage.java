package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private final SelenideElement registrationButton =
            $(byText("Вход и регистрация"));

    public RegisterPage showRegistration() {
        openBaseUrl();
        registrationButton.click();
        LoginPage loginPage = new LoginPage();
        return loginPage.goToRegistration();
    }

}
