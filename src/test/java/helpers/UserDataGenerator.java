package helpers;

import models.User;
import java.util.UUID;

public class UserDataGenerator {

    public static User generateUser() {
        String unique = UUID.randomUUID().toString().substring(0, 8);

        return new User(
                "gens" + unique + "@gmail.com",
                "olga123@!"
        );
    }
}