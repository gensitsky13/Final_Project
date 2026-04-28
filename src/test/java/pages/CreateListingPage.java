package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class CreateListingPage extends BasePage {


    private final SelenideElement createListingContainer =
            $x("//*[contains(text(),'Новое объявление')]/ancestor::div[1]");

    private final SelenideElement titleInput =
            $x("//input[@placeholder='Название']");

    //private final SelenideElement publishButton =
           // $x("//button[contains(., 'Разместить объявление')]");
    private final SelenideElement publishButton =
            $x("//button[contains(., 'Опубликовать')]");

    public void shouldBeOpened() {
        $x("//*[contains(text(),'Новое объявление')]").shouldBe(visible);
        titleInput.shouldBe(visible);
    }

    public void enterTitle(String title) {
        titleInput.shouldBe(visible, enabled).clear();
        titleInput.setValue(title);
        titleInput.shouldHave(value(title));

    }

    public void clickPublish() {
        publishButton.shouldBe(visible, enabled).scrollIntoView(true);

        try {
            publishButton.click();
        } catch (Exception e) {
            executeJavaScript("arguments[0].click();", publishButton);
        }


    }
}