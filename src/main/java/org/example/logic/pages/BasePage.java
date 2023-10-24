package org.example.logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;
    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, 10);
    }
    public MobileElement waitFor(By by){
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
