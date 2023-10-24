package org.example.logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TaskPage extends BasePage{
    private MobileElement deleteBTN;
    private MobileElement desc;
    private MobileElement taskName;
    public TaskPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }
    private void init(){
        this.deleteBTN = driver.findElement(By.id("com.claudivan.taskagenda:id/item_excluir"));
        this.taskName = driver.findElement(By.id("com.claudivan.taskagenda:id/tvTitulo"));
        this.desc = driver.findElement(By.id("com.claudivan.taskagenda:id/tvDescricao"));
    }

    public boolean confirmTaskName(String str){
        return taskName.getText().equals(str);
    }
    public boolean confirmTaskDesc(String str){
        return desc.getText().equals(str);
    }

    public void deleteTask(){
        deleteBTN.click();
        MobileElement confirm = driver.findElement(By.id("android:id/button1"));
        confirm.click();
    }
}
