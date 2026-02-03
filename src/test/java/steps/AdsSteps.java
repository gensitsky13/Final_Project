package steps;

import di.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Ad;
import pages.AdEditPage;
import pages.AdsPage;
import utils.TestData;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;

public class AdsSteps {

    private final TestContext ctx;
    private final AdsPage adsPage;
    private final AdEditPage adEditPage;

    public AdsSteps(TestContext ctx) {
        this.ctx = ctx;
        this.adsPage = new AdsPage();
        this.adEditPage = new AdEditPage();
    }

    @When("пользователь создает объявление")
    public void createAd() {
        Ad ad = TestData.newAdAnyCategory();
        ctx.setAd(ad);

        adsPage.openCreateForm();
        adsPage.createAd(ad);
    }

    @Then("объявление отображается в списке")
    public void adVisibleInList() {
        adsPage.adCardByTitle(ctx.getAd().getTitle()).should(exist);
    }

    @When("пользователь редактирует свое объявление изменяя заголовок")
    public void editAdTitle() {
        adsPage.openAdByTitle(ctx.getAd().getTitle());

        adEditPage.clickEdit();

        String newTitle = ctx.getAd().getTitle() + "_edited";
        ctx.setAd(new Ad(newTitle, ctx.getAd().getDescription(), ctx.getAd().getCategory()));

        adEditPage.changeTitle(newTitle);
    }

    @Then("изменения объявления сохранены")
    public void changesSaved() {
        adsPage.adCardByTitle(ctx.getAd().getTitle()).should(exist);
    }

    @When("пользователь удаляет свое объявление")
    public void deleteAd() {
        adsPage.openAdByTitle(ctx.getAd().getTitle());
        adEditPage.deleteAd();
    }

    @Then("объявление удалено и не отображается в списке")
    public void adDeleted() {
        adsPage.adCardByTitle(ctx.getAd().getTitle()).should(not(exist));
    }
}

