package config;

import com.codeborne.selenide.Configuration;

public final class DriverHooks {
    private DriverHooks() {}

    public static void setup() {
        Configuration.baseUrl = TestConfig.UI_BASE_URL;
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.timeout = 8000;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
    }
}