package com.krupa.learning.selenium;

import com.krupa.learning.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void LoginWithInvalidUsername_ShowsError() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("wrongUser", "SuperSecretPassword!");

        String msg = loginPage.getFlashMessage();
        System.out.println(msg);

        Assert.assertTrue(msg.contains("Your username is invalid!"));
    }

    @Test
    public void LoginWithInvalidPassword_ShowsError() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("tomsmith", "wrongPassword");

        String msg = loginPage.getFlashMessage();
        System.out.println(msg);

        Assert.assertTrue(msg.contains("Your password is invalid!"));
    }
}
