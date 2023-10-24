package org.example.logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TaskCreation extends BasePage{
    private final By save = By.id("com.claudivan.taskagenda:id/item_salvar");
    private final By nameField = By.id("com.claudivan.taskagenda:id/etTitulo");
    private final By type = By.id("com.claudivan.taskagenda:id/tvTipo");
    private final By desc = By.id("com.claudivan.taskagenda:id/etDescricao");
    public TaskCreation(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void clickSave(){
        driver.findElement(save).click();
    }
    public void writeName(String str){
        driver.findElement(nameField).sendKeys(str);
    }
    public void selectType(String str){
        driver.findElement(type).click();
        if (str.equals("Important")){
            driver.findElement(By.xpath("//*[@text='Important']")).click();
        }
        if (str.equals("Task")){
            driver.findElement(By.xpath("//*[@text='Task']")).click();
        }
        if (str.equals("Not forget")){
            driver.findElement(By.xpath("//*[@text='Not forget']")).click();
        }
    }
    public void writeDesc(String str){
        driver.findElement(desc).sendKeys(str);
    }
}
