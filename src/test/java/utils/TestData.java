package utils;

import models.Ad;
import models.User;

public class TestData {

    public static User validUser() {
        String email = "test_" + System.currentTimeMillis() + "@mail.com";
        String password = "Password123";
        return new User(email, password);
    }

    public static Ad newAdAnyCategory() {

        String title = "Ad_" + System.currentTimeMillis();
        String category = "Авто";
        String condition = "Новый";
        String city = "Москва";
        String description = "Test description";
        String price = "100";

        return new Ad(title, category, condition, city, description, price);
    }
}