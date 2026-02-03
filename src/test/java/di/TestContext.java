package di;

import models.Ad;
import models.User;

public class TestContext {

    private User user;
    private Ad ad;

    // --- User context ---
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // --- Ad context ---
    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }
}