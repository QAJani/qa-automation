package com.krupa.learning.selenium;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import com.krupa.learning.pages.LoginPage;
import com.krupa.learning.pages.SecureAreaPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        // Disable password manager + leak detection popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        // This one prevents the “password found in a data breach” UI in many Chrome
        // versions
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected SecureAreaPage loginAsValidUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("tomsmith", "SuperSecretPassword!");
        wait.until(ExpectedConditions.urlContains("/secure"));
        return new SecureAreaPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
