package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AdEditPage extends BasePage {
    private final SelenideElement editBtn = $("#edit");          // TODO
    private final SelenideElement deleteBtn = $("#delete");      // TODO
    private final SelenideElement confirmDelete = $("#confirm"); // TODO

    private final SelenideElement title = $("#title");           // TODO
    private final SelenideElement saveBtn = $("#save");          // TODO

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
}

