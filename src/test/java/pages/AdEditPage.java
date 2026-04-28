package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class AdEditPage extends BasePage {
    private final SelenideElement deleteBtn = $("#delete");
    private final SelenideElement confirmDelete = $("#confirm");

    private final SelenideElement title = $("#title");
    private final SelenideElement saveBtn = $("#save");


    private final SelenideElement editBtn =
            $x("//button[contains(., 'Редактировать объявление')]");

    private final SelenideElement titleInput = $("input[name='name']");

    private final SelenideElement saveButton =
            $x("//button[contains(., 'Сохранить')]");

    public void clickEdit() {
        editBtn.shouldBe(visible, enabled).scrollIntoView(true);

        try {
            editBtn.click();
        } catch (Exception e) {
            executeJavaScript("arguments[0].click();", editBtn);
        }
       // sleep(2000);

titleInput.shouldBe(visible, Duration.ofSeconds(10));

    }

    public void changeTitle(String newTitle) {
        titleInput.shouldBe(visible, enabled);
        titleInput.clear();
        titleInput.setValue(newTitle);
        titleInput.shouldHave(value(newTitle));

        saveButton.shouldBe(visible, enabled).click();
        saveButton.should(disappear);
    }
}




