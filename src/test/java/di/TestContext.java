package di;

import models.Ad;
import models.User;

public class TestContext {
    private static TestContext ctx;

    private User user;
    private Ad ad;

    static TestContext getInstance() {
        if (ctx == null) {
            ctx = new TestContext();
        }
        return ctx;
    }


    public static User getUser() {
        return getInstance().user;
    }

    public static void setUser(User user) {
        getInstance().user = user;
    }


    public static Ad getAd() {
        return getInstance().ad;
    }

    public static void setAd(Ad ad) {
        getInstance().ad = ad;
    }
}