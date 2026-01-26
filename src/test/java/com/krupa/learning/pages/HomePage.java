package com.krupa.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    // Locators
    private final By headingH1 = By.tagName("h1");
    private final By subHeadingH2 = By.tagName("h2");
    private final By abTestingLink = By.cssSelector("a[href='/abtest']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMainHeading() {
        return driver.findElement(headingH1).getText().trim();
    }

    public String getSubHeading() {
        return driver.findElement(subHeadingH2).getText().trim();
    }

    public void clickABTesting() {
        driver.findElement(abTestingLink).click();
    }
}
