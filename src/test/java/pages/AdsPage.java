
package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class AdsPage {

    private final SelenideElement adsPageContainer =
            $(".ads-page, .ads-list");


    private final SelenideElement placeAdButton =
            $x("//button[contains(.,'Разместить объявление')]");

    public AdsPage shoulBeOpened() {
        webdriver().shouldHave(urlContaining("/ads"));
        placeAdButton.shouldBe(visible);
        return this;
    }

    public AdsPage clickPlaceAd() {
        System.out.println("DEBUG: clickPlaceAd called");
        System.out.println("DEBUG: placeAdButton text = " + placeAdButton.getText());

        placeAdButton.shouldBe(visible, enabled).scrollIntoView(true);

        try {
            placeAdButton.click();
            System.out.println("DEBUG: regular click done");
        } catch (Exception e) {
            System.out.println("DEBUG: regular click failed, fallback to JS click");
            executeJavaScript("arguments[0].click();", placeAdButton);
        }

        return this;
    }

    public SelenideElement adCardByTitle(String title) {

        return $(byText(title));
    }

   // public void shouldBeOpened() {
      //  webdriver().shouldHave(urlContaining("/ads"));
   //}


    public void open() {
        Selenide.open("https://qa-desk.stand.praktikum-services.ru/ads");
    }
}
