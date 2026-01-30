package com.krupa.learning.selenium;

import com.krupa.learning.data.LoginDataProvider;
import com.krupa.learning.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends BaseTest {

    @Test(dataProvider = "invalidLoginData", dataProviderClass = LoginDataProvider.class, groups = { "regression" })
    public void LoginWithInvalidCredentials_ShowsError(
            String username,
            String password,
            String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getFlashMessage().contains(expectedMessage));
    }

}
