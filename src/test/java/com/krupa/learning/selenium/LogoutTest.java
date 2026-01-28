package com.krupa.learning.selenium;

import com.krupa.learning.pages.SecureAreaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void LogoutSuccessfully() {

        SecureAreaPage securePage = loginAsValidUser();

        // click logout (your reliable version)
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a.button.secondary.radius"))).click();

        wait.until(ExpectedConditions.urlContains("/login"));

        Assert.assertTrue(
                driver.getPageSource().contains("You logged out of the secure area!"));
    }
}
