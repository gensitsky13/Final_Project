package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.DriverHooks;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @Before
    public void openBrowser() {
        clearBrowserCookies();
        Configuration.baseUrl = "https://qa-desk.stand.praktikum-services.ru";
        open("/");
    }

    @After
    public  void tearDown() {

        Selenide.closeWebDriver();
    }
}

