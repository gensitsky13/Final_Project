package steps;

import io.cucumber.java.en.Given;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class CommonSteps {

    @Given("открыт экран {string}")
    public void openScreen(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        open(path);
    }
}
