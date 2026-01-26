package com.krupa.learning.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void LoginWithValidCredentials() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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

        } finally {
            driver.quit();
        }
    }
}
