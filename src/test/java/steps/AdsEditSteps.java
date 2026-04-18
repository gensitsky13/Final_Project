package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import models.Ad;
import pages.AdEditPage;
import pages.AdsPage;
import di.TestContext;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AdsEditSteps {

    private final TestContext testContext;
    private final AdsPage adsPage = new AdsPage();
    private final AdEditPage adEditPage = new AdEditPage();

    public AdsEditSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @И("пользователь редактирует свое объявление, изменяя заголовок")
    public void userEditsAd() {
        String oldTitle = testContext.getCurrentAd().getTitle();
        String newTitle = "Updated " + System.currentTimeMillis();

        adsPage.adCardByTitle(oldTitle).click();
        SelenideElement el = $x("//h2[contains(., '" + oldTitle + "')]")
                .shouldBe(visible)
                .scrollIntoView(true);

        try {
            el.click();
        } catch (Exception e) {
            executeJavaScript("arguments[0].click();", el);
        }


        sleep(2000);

        adEditPage.clickEdit();
        sleep(1000);
        adEditPage.changeTitle(newTitle);
        sleep(2000);

        Ad oldAd = testContext.getCurrentAd();
        Ad updatedAd = new Ad(
                newTitle,
                oldAd.getCategory(),
                oldAd.getCondition(),
                oldAd.getCity(),
                oldAd.getDescription(),
                oldAd.getPrice()
        );

        testContext.setCurrentAd(updatedAd);
    }

    @Тогда("изменения объявления сохранены")
    public void adUpdated() {

        adsPage.adCardByTitle(testContext.getCurrentAd().getTitle())
                .shouldBe(visible);
    }
}