package utils;

import java.util.UUID;

public final class RandomData {
    private RandomData() {}

    public static String uniqueEmail() {
        return "qa_" + UUID.randomUUID().toString().substring(0, 8) + "@test.com";
    }

    public static String strongPassword() {
        return "Pass_" + UUID.randomUUID().toString().substring(0, 8) + "123456";
    }

    public static String shortText() {
        return "txt_" + UUID.randomUUID().toString().substring(0, 6);
    }
}
