
package pages;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class AdsPage {

    private final SelenideElement adsPageContainer = $("body");
    private final SelenideElement searchInput = $("input[name='name']");
    private final SelenideElement searchArrowButton =
            $x("//input[@name='name']/ancestor::div[1]/following-sibling::button");



    private final SelenideElement placeAdButton =
            $x("//button[contains(.,'Разместить объявление')]");
    private final SelenideElement applyButton =
            $x("//button[contains(., 'Применить')]");


    public AdsPage shouldBeOpened() {
        webdriver().shouldHave(urlContaining("/"));
        placeAdButton.shouldBe(visible);
        return this;
    }

    public AdsPage clickPlaceAd() {
        placeAdButton.shouldBe(visible, enabled).scrollIntoView(true);

        try {
            placeAdButton.click();
        } catch (Exception e) {
            executeJavaScript("arguments[0].click();", placeAdButton);
        }

        return this;
    }



    public AdsPage searchByTitle(String title) {
        searchInput.shouldBe(visible, enabled).scrollIntoView(true).click();

        searchInput.clear();
        searchInput.setValue(title);

        searchInput.shouldHave(value(title));

        applyButton.shouldBe(visible, enabled).scrollIntoView(true);

        try {
            applyButton.click();
        } catch (Exception e) {
            executeJavaScript("arguments[0].click();", applyButton);
        }


        return this;
    }


    public SelenideElement adCardByTitle(String title) {
        return $x("//*[contains(., '" + title + "')]");
    }
}