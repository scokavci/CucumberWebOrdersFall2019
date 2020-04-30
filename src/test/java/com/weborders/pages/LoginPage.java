package com.weborders.pages;

import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="ctl00_MainContent_username")
    private WebElement username;

    @FindBy(id="ctl00_MainContent_password")
    private WebElement password;

    @FindBy(tagName ="h1")
    protected WebElement pageLogo;

    //same action but different parameter list
    //log in with credentials or not

    public void login(){
        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public String getPageLogoText(){
        return pageLogo.getText();
    }

}
