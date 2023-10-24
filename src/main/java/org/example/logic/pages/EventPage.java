package org.example.logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class EventPage extends BasePage {
    private final By addNewEventId = By.id("com.claudivan.taskagenda:id/btNovoEvento");
    private final By searchIcon = By.id("com.claudivan.taskagenda:id/search");
    private final By searchBar = By.id("com.claudivan.taskagenda:id/etSearch");


    public EventPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void addEvent(){
        driver.findElement(addNewEventId).click();
    }
    public boolean confirmTask(String str){
        try {
            By elementLocator = By.xpath("//*[@text='"+ str +"']");
            MobileElement element = driver.findElement(elementLocator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickSearch(){
        driver.findElement(searchIcon).click();
    }
    public void searchFor(String str){
        driver.findElement(searchBar).sendKeys(str);
    }
    public boolean confirmSearch(String str) throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.id("com.claudivan.taskagenda:id/tvTitulo")).getText().equals(str);
    }
    public void clickOnTask(String str){
        if (confirmTask(str)){
            driver.findElement(By.id("com.claudivan.taskagenda:id/tvTitulo")).click();
        }
    }
}
