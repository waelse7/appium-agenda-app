package org.example.logic.components;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.logic.pages.BasePage;
import org.example.logic.pages.HomePage;
import org.openqa.selenium.By;

public class CalendarComponent extends HomePage {
    private By viewEventsId = By.id("com.claudivan.taskagenda:id/btEventosMes");
    private MobileElement viewEvents;
    public CalendarComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }
    private void init(){
        this.viewEvents = driver.findElement(viewEventsId);
    }
    public void viewEvents(){
        viewEvents.click();
    }
    public void clickOnDay(String str){
        driver.findElement(By.xpath("//*[@text='"+ str +"']")).click();
    }
}
