package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdEditPage extends BasePage {
    private final SelenideElement editBtn = $("#edit");
    private final SelenideElement deleteBtn = $("#delete");
    private final SelenideElement confirmDelete = $("#confirm");

    private final SelenideElement title = $("#title");
    private final SelenideElement saveBtn = $("#save");

    public void clickEdit() { editBtn.click(); }

    public void changeTitle(String newTitle) {
        title.clear();
        title.setValue(newTitle);
        saveBtn.click();
    }

    public void deleteAd() {
        deleteBtn.click();
        confirmDelete.click();
    }
    private final SelenideElement titleInput = $("#title");
    private final SelenideElement descriptionInput = $("#description");
    private final SelenideElement saveButton = $x("//button[contains(.,'Сохранить')]");

    public void fillTitle(String title) {
        titleInput.shouldBe(visible).setValue(title);
    }

    public void fillDescription(String description) {
        descriptionInput.shouldBe(visible).setValue(description);
    }

    public void save() {
        saveButton.shouldBe(visible).click();
    }
}

