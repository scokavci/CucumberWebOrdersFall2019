package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {

  @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
  private WebElement productSelect;

  @FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
  private WebElement enterQuantity;

  @FindBy(id="ctl00_MainContent_fmwOrder_txtUnitPrice")
  private WebElement enterpricePerUnit;

  @FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
  private WebElement enterdiscount;

  @FindBy(css = "[type='submit']")
  private WebElement calculate;

  @FindBy(id="ctl00_MainContent_fmwOrder_txtTotal")
  private WebElement total;

  @FindBy(id="ctl00_MainContent_fmwOrder_txtName")
  private WebElement customer_name;

  @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
  private WebElement street;

  @FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
  private WebElement city;

  @FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
  private WebElement state;

  @FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
  private WebElement zip;

  @FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
  private WebElement card_number;

  @FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
  private WebElement expire_date;

  @FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
  private WebElement processBtn;

    public void selectProduct(String productname){
        Select select = new Select(productSelect);
        select.selectByVisibleText(productname);
    }
    public void enterQuantity(String quantity){
        enterQuantity.clear();
        enterQuantity.sendKeys(quantity, Keys.ENTER);
    }
    public void enterPricePerUnit(String priceperunit){
        enterpricePerUnit.sendKeys(priceperunit,Keys.ENTER);
    }
    public void enterDiscount(String discount){
        enterdiscount.sendKeys(discount,Keys.ENTER);
    }

    public void clickToCalculate(){
        calculate.click();
    }
    public int totalDisplayed(){
         return Integer.parseInt(  total.getAttribute("value"));
    }

    public void enterCustomerName(String customername){
        customer_name.sendKeys(customername,Keys.ENTER);
    }
    public void enterStreetName(String streetinfo){
        street.sendKeys(streetinfo,Keys.ENTER);
    }
    public void enterCityName(String cityname){
        city.sendKeys(cityname,Keys.ENTER);
    }
    public void enterStateName(String statename){
        state.sendKeys(statename,Keys.ENTER);
    }
    public void enterZip(String zipcode){
        zip.sendKeys(zipcode,Keys.ENTER);
    }

    public void enterCard(String cardtype){
        String path = "//label[text()='"+cardtype+"']/../input";
        WebElement cardcheckbox = driver.findElement(By.xpath(path));
        wait.until(ExpectedConditions.elementToBeClickable(cardcheckbox)).click();
    }

    public void enterCardNumber(String cardnumber){
        card_number.sendKeys(cardnumber,Keys.ENTER);
    }
    public void enterExpireDate(String expiredate){
        expire_date.sendKeys(expiredate,Keys.ENTER);
    }
    public WebElement processBtn(){
        return processBtn;
    }




}
