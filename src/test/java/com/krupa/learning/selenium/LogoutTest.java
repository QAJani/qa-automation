package com.krupa.learning.selenium;

import com.krupa.learning.pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(groups = { "regression" })
    public void LogoutSuccessfully() {
        SecureAreaPage securePage = loginAsValidUser();
        securePage.logout();
        securePage.waitForLogoutRedirect();

        Assert.assertTrue(
                driver.getPageSource().contains("You logged out of the secure area!"));
    }

}
