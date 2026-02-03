package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    // ✅ База стенда (можно потом вынести в config)
    protected static final String BASE_URL = "https://qa-desk.stand.praktikum-services.ru/";

    // ✅ Общие элементы (если на всех страницах есть шапка/контент)
    protected final SelenideElement body = $("body");

    // ✅ Открыть главную страницу стенда
    public void openBaseUrl() {
        open(BASE_URL);
        body.should(appear); // простая проверка что DOM появился
    }

    // ✅ Универсальная проверка, что элемент видим (удобно в Page Objects)
    protected void shouldBeVisible(SelenideElement element) {
        element.shouldBe(visible);
    }
}