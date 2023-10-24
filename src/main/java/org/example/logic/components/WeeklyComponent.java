package org.example.logic.components;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.logic.pages.BasePage;
import org.example.logic.pages.HomePage;
import org.openqa.selenium.By;

public class WeeklyComponent extends HomePage {
    private final By addNewEventId = By.id("com.claudivan.taskagenda:id/btNovoEvento");
    private final By viewEventId = By.id("com.claudivan.taskagenda:id/btEventosSemana");
    private final By todayPath = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
    private final By tomorrowPath = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
    private final By otherPath = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");

    private MobileElement viewEvents;
    private MobileElement addNewEvent;

    public WeeklyComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }
    private void init(){
        this.viewEvents = driver.findElement(viewEventId);
        this.addNewEvent = driver.findElement(addNewEventId);
    }
    public void addEvent(){
        addNewEvent.click();
    }
    public void viewEvents(){
        viewEvents.click();
    }
    public void clickToday(){
        driver.findElement(todayPath).click();
    }
    public void clickTomorrow(){
        driver.findElement(tomorrowPath).click();
    }
    public void clickOther(){
        driver.findElement(otherPath).click();
    }
}
