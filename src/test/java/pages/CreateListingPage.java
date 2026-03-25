package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class CreateListingPage extends BasePage {


    private final SelenideElement titleInput =
            $("[name='name']");

    // финальная кнопка публикации на этой странице (вторая "Разместить объявление")
    private final SelenideElement publishButton =
            $$("button").findBy(text("Разместить объявление"));

    public void shouldBeOpened() {
        $(byText("Добавить фото")).shouldBe(visible);
        $x("//*[contains(text(),'Новое объявление')]").shouldBe(visible);
    }



    public void enterTitle(String title) {
        titleInput.shouldBe(editable).setValue(title);
    }

    public void clickPublish() {
        publishButton.shouldBe(enabled).click();
    }
}