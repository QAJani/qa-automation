package com.krupa.learning.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void verifyHeadingText() {
        // Locator by tag name
        String heading = driver.findElement(By.tagName("h1")).getText();

        // Assertion
        Assert.assertEquals(heading, "Welcome to the-internet",
                "Heading text did not match");
        // Locator by linkText
        // String linkText = driver.findElement(By.linkText("A/B Testing")).getText();
        // Assert.assertEquals(linkText, "A/B Testing");
        // Locator by xPath
        String subheading = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(subheading, "Available Examples");
        // Locator by CSSSelector
        String abLinkCss = driver.findElement(By.cssSelector("a[href='/abtest']")).getText();
        Assert.assertEquals(abLinkCss, "A/B Testing", "A/B Testing link text did not match");
        // Actions
        driver.findElement(By.cssSelector("a[href='/abtest']")).click();
        String title = driver.findElement(By.cssSelector("h3")).getText();
        Assert.assertTrue(
                title.equals("A/B Test Control") || title.equals("A/B Test Variation 1"),
                "Unexpected heading. Actual: " + title);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
