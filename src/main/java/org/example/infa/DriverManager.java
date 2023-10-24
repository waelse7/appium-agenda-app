package org.example.infa;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver<MobileElement> driver;
    public static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }
    public static void initializeDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appium:platformVersion", "13");
        capabilities.setCapability("appium:appPackage", "com.claudivan.taskagenda");
        capabilities.setCapability("appium:appActivity", "com.claudivan.taskagenda.Activities.MainActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
    public static void closeDriver() {
        getDriver().quit();
        driver = null;
    }
}
