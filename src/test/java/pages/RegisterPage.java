package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class RegisterPage extends BasePage {

    // кнопка сабмита в модалке
    private final SelenideElement submitButton =
            $(byText("Создать аккаунт"));

    public void open() {
        Selenide.open("/register");

    }

    // ✅ Позитивный сценарий (используется ТОЛЬКО для успешной регистрации)
    public void registerSuccessfully(String email, String password) {
        $("input[placeholder='Введите Email']").setValue(email);
        $("input[placeholder='Пароль']").setValue(password);
        $("input[placeholder='Повторите пароль']").setValue(password);

        submitButton.click();
    }

    //  Проверка ошибки
    public void shouldSeeDuplicateEmailError() {
        $(byText("Ошибка")).shouldBe(visible);
    }
}
