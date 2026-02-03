package steps;

import com.codeborne.selenide.Selenide;
import config.DriverHooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeScenario() {
        DriverHooks.setup();
    }

    @After
    public void afterScenario() {
        Selenide.closeWebDriver();
    }
}

