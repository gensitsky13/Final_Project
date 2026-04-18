package pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {


    private final SelenideElement loginButton = $(byText("Вход и регистрация"));


    private final SelenideElement placeAdButton = $(byText("Разместить объявление"));


    public void shouldBeLoggedOut() {
        loginButton.shouldBe(visible);
    }


    public void shouldBeLoggedIn() {
        placeAdButton.shouldBe(visible);
    }



    public void clickPlaceAd() {
        placeAdButton.shouldBe(visible).scrollTo().click();
    }

}
