package com.krupa.learning.selenium;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
    @Test
    public void verifyGoogleTitle() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        Assert.assertEquals(title, "Google");

        driver.quit();
    }
}
