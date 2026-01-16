package com.krupa.learning.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void verifyAddition() {
        int a = 5;
        int b = 10;
        int sum = a + b;

        Assert.assertEquals(sum, 15, "Addition validation failed");
    }
}
