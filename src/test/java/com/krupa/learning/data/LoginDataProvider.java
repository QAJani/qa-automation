package com.krupa.learning.data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][] {
                { "wrongUser", "SuperSecretPassword!", "Your username is invalid!" },
                { "tomsmith", "wrongPassword", "Your password is invalid!" }
        };
    }
}
