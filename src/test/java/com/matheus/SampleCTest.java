package com.matheus;

import com.matheus.pages.HomePage;
import com.matheus.setup.TestRule;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleCTest extends TestRule {

    @Test
    public void browserstackSampleCTest() {
        String connectionStatus = new HomePage(driver)
                .checkConnection()
                .waitConnectionResultToBeVisible()
                .getConnectionTextView()
                .getText();

        Assert.assertTrue(connectionStatus.contains("Up and running"));
    }
}