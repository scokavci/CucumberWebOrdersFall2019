package com.weborders.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewAllOrdersPage extends BasePage {

    @FindBy(xpath="//table[@class='SampleTable']//tr[2]//td[2]")
    private WebElement namedisplay;

    @FindBy(xpath="//table[@class='SampleTable']//tr[2]//td[6]")
    private WebElement streetdisplay;

    @FindBy(xpath="//table[@class='SampleTable']//tr[2]//td[7]")
    private WebElement citydisplay;

    @FindBy(xpath="//table[@class='SampleTable']//tr[2]//td[8]")
    private WebElement statedisplay;

    @FindBy(xpath="//table[@class='SampleTable']//tr[2]//td[9]")
    private WebElement zipdisplay;

    public String nameDisplay(){
        return namedisplay.getText();
    }
    public String streetDisplay(){
        return streetdisplay.getText();
    }
    public String cityDisplay(){
        return citydisplay.getText();
    }
    public String stateDisplay(){
        return statedisplay.getText();
    }
    public String zipDisplay(){
        return zipdisplay.getText();
    }
}
