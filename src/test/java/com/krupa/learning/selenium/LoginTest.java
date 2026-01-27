package com.krupa.learning.selenium;

import com.krupa.learning.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open()
                .login("tomsmith", "SuperSecretPassword!");

        // Using your Chapter 5 wait from BaseTest
        wait.until(ExpectedConditions.urlContains("/secure"));

        Assert.assertTrue(
                loginPage.getFlashMessage().contains("You logged into a secure area!"));
    }
}
