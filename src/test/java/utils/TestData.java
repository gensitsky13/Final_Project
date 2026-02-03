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
        // ВАЖНО: подстрой под твой конструктор Ad
        // Я даю безопасный шаблон: если у Ad другой конструктор — скажи, я подгоню 1-в-1.
        String title = "Ad_" + System.currentTimeMillis();
        String description = "Test description";
        String price = "100";

        return new Ad(title, description, price);
    }
}