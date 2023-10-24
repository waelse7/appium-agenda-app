package org.example.logic.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private MobileElement calendar;
    private MobileElement week;
    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }
    private void init(){
        this.calendar = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Calendar\")"));
        this.week = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Week\")"));
    }
    public void moveToCalendar() throws Exception {
        if (!calendar.isSelected()){
            calendar.click();
        }
    }
    public void moveToWeek() throws Exception {
        if (!week.isSelected()){
            week.click();
        }
    }

}
