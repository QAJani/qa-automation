package com.krupa.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorTest {

    @Test
    public void verifyHeadingText() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        // Locator by tag name
        String heading = driver.findElement(By.tagName("h1")).getText();

        // Assertion
        Assert.assertEquals(heading, "Welcome to the-internet",
                "Heading text did not match");

        driver.quit();
    }
}
