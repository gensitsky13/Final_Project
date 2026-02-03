package pages;

import com.codeborne.selenide.SelenideElement;
import models.Ad;

import static com.codeborne.selenide.Selenide.*;

public class AdsPage extends BasePage {
    private final SelenideElement createBtn = $("#createAd");  // TODO
    private final SelenideElement title = $("#title");         // TODO
    private final SelenideElement description = $("#desc");    // TODO
    private final SelenideElement category = $("#category");   // TODO (select)
    private final SelenideElement saveBtn = $("#save");        // TODO

    public void openCreateForm() { createBtn.click(); }

    public void createAd(Ad ad) {
        title.setValue(ad.getTitle());
        description.setValue(ad.getDescription());
        // category.selectOption(ad.getCategory()); // если select
        saveBtn.click();
    }

    public SelenideElement adCardByTitle(String titleText) {
        // TODO: под твой UI
        return $$("[data-test='ad-card']").findBy(com.codeborne.selenide.Condition.text(titleText));
    }

    public void openAdByTitle(String titleText) {
        adCardByTitle(titleText).click();
    }
}
