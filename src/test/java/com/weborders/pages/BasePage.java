package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver = Driver.getDriver();  // shortcut to driver
    protected WebDriverWait wait = new WebDriverWait(driver,30);

    public BasePage(){
        PageFactory.initElements(driver,this);
    }

    public void navigateTo(String moduleName){
        String modulePath = "//a[text()='"+moduleName+"']";
        WebElement moduleXPath = driver.findElement(By.xpath(modulePath));
        moduleXPath.click();
    }

}
