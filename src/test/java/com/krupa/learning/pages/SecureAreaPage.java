package com.krupa.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private final By flashMessage = By.id("flash");
    private final By logoutButton = By.cssSelector("a.button.secondary.radius");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getFlashMessage() {
        return getText(flashMessage);
    }

    public void logout() {
        click(logoutButton);
    }

    public void waitForPage() {
        waitUrlContains("/secure");
    }

    public void waitForLogoutRedirect() {
        waitUrlContains("/login");
    }

}
