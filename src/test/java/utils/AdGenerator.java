package utils;

import models.Ad;

import java.util.UUID;

public class AdGenerator {

    public Ad createAd() {
        String title = "olgatest " + System.currentTimeMillis();
        String category = "Авто";
        String condition = "Б/у";
        String city = "Москва";
        String description = "Test description";
        String price = "1000";

        return new Ad(title, category, condition, city, description, price);
    }
}