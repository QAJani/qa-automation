package com.krupa.learning.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void LoginWithValidCredentials() {

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("/secure"));

        String flashText = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")))
                .getText();

        System.out.println(flashText);
        Assert.assertTrue(flashText.contains("You logged into a secure area!"));
    }
}
