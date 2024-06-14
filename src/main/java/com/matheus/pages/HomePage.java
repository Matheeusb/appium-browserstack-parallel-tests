package com.matheus.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final AppiumDriver driver;

    private final WebDriverWait wait;

    @AndroidFindBy(id = "com.example.android.basicnetworking:id/test_action")
    @iOSXCUITFindBy(accessibility = "Test BrowserStackLocal connection")
    private WebElement textButton;

    @Getter
    @AndroidFindBy(id = "com.example.android.basicnetworking:id/textView")
    @iOSXCUITFindBy(accessibility = "ResultBrowserStackLocal")
    private WebElement connectionTextView;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HomePage checkConnection() {
        wait.until(ExpectedConditions.elementToBeClickable(textButton)).click();

        return this;
    }

    public HomePage waitConnectionResultToBeVisible() {
        if (driver.getCapabilities().getPlatformName().name().equalsIgnoreCase(Platform.ANDROID.name())) {
            wait.until(ExpectedConditions.textToBePresentInElement(connectionTextView, "The active connection is"));
        } else {
            wait.until(ExpectedConditions.attributeToBeNotEmpty(connectionTextView, "value"));
        }

        return this;
    }



}
