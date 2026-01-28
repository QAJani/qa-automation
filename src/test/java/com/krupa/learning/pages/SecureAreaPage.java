package com.krupa.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    private final WebDriver driver;

    // Locators
    private final By flashMessage = By.id("flash");
    private final By logoutButton = By.cssSelector("a.button.secondary.radius");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFlashMessage() {
        return driver.findElement(flashMessage).getText();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}
