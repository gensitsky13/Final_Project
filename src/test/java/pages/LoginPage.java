package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private final SelenideElement email = $("#email");
    private final SelenideElement password = $("#password");
    private final SelenideElement submit = $("#submit");

    // Кнопка "Нет аккаунта" находится на ЛОГИН-модалке
    private final SelenideElement noAccountButton =
            $x("//button[contains(.,'Нет аккаунта')]");

    public void waitForOpen() {
        submit.shouldBe(Condition.visible);
    }

    public void login(String e, String p) {
        email.shouldBe(Condition.visible).setValue(e);
        password.shouldBe(Condition.visible).setValue(p);
        submit.shouldBe(Condition.visible).click();
    }




    public RegisterPage goToRegistration() {
        noAccountButton.shouldBe(Condition.visible).click();
        return  new RegisterPage();
    }

}

