package config;

public final class TestConfig {
    private TestConfig() {

    }


    public static final String UI_BASE_URL = System.getProperty("ui.baseUrl", "https://qa-desk.education-services.ru");
    public static final String API_BASE_URL = System.getProperty("api.baseUrl", "https://qa-desk.education-services.ru/");


}