package steps;

import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {

    @Given("открыт экран {string}")
    public void openScreen(String path) {
        // path: "/register", "/login", "/ads"
        open(path);
    }
}
