package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {


    protected static final String BASE_URL = "https://qa-desk.stand.praktikum-services.ru/";

    protected final SelenideElement body = $("body");

    public void openBaseUrl() {
        open(BASE_URL);
        body.should(appear);
    }

    public void shouldBeVisible(SelenideElement element) {
        element.shouldBe(visible);
    }
}