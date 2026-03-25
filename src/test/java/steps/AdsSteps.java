package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import models.Ad;
import models.User;
import pages.AdsPage;
import pages.CreateListingPage;
import di.TestContext;
import pages.LoginPage;
import pages.MainPage;
import utils.AdGenerator;

import static com.codeborne.selenide.Condition.exist;

public class AdsSteps {

    private final AdsPage adsPage = new AdsPage();
    private final CreateListingPage createListingPage = new CreateListingPage();
    private final AdGenerator adGenerator = new AdGenerator();
    private final MainPage mainPage = new MainPage();

    @Когда("пользователь создает объявление")
    public void userCreatesAd() {
        User user = TestContext.getUser();
        LoginPage loginPage = new LoginPage();
        Ad ad = adGenerator.createAd();
        TestContext.setAd(ad);


       mainPage.clickPlaceAd();

        createListingPage.shouldBeOpened();
        createListingPage.enterTitle(ad.getTitle());
        createListingPage.clickPublish();
    }

    @Тогда("объявление отображается в списке")
    public void adIsDisplayedInList() {
        adsPage
                .adCardByTitle(TestContext.getAd().getTitle())
                .should(exist);
    }
}

