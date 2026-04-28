package steps;


import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import models.Ad;

import pages.AdsPage;
import pages.CreateListingPage;
import di.TestContext;
import pages.MainPage;
import utils.AdGenerator;
import static com.codeborne.selenide.Condition.visible;



public class AdsSteps {

    private final AdsPage adsPage = new AdsPage();
    private final CreateListingPage createListingPage = new CreateListingPage();
    private final AdGenerator adGenerator = new AdGenerator();
    private final MainPage mainPage = new MainPage();
    private final TestContext testContext;

    public AdsSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Когда("пользователь создает объявление")
    public void userCreatesAd() {
        Ad ad = adGenerator.createAd();
        testContext.setCurrentAd(ad);


       mainPage.clickPlaceAd();
        createListingPage.shouldBeOpened();
        createListingPage.enterTitle(ad.getTitle());
        createListingPage.clickPublish();

    }
    @Когда("пользователь ищет объявление по title")
    public void userSearchesAdByTitle() {
        String title = testContext.getCurrentAd().getTitle();
        adsPage.searchByTitle(title);
    }
    @Тогда("объявление отображается в списке")
    public void adIsDisplayedInList() {
        adsPage.shouldBeOpened();

        adsPage
                .adCardByTitle(testContext.getCurrentAd().getTitle())
                .shouldBe(visible);
    }

}

