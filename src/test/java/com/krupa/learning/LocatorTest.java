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
        Assert.assertEquals(title, "A/B Test Control", "Incorrect heading match");
        driver.quit();
    }
}
