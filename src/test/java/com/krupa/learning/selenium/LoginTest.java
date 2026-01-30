package com.krupa.learning.selenium;

import com.krupa.learning.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = { "smoke" })
    public void LoginWithValidCredentials() {
        SecureAreaPage securePage = loginAsValidUser();
        Assert.assertTrue(
                securePage.getFlashMessage().contains("You logged into a secure area!"));
    }

}
