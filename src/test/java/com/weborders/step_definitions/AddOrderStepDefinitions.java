package com.weborders.step_definitions;

import com.weborders.pages.OrderPage;
import com.weborders.pages.ViewAllOrdersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AddOrderStepDefinitions {
    OrderPage orderpage = new OrderPage();
    ViewAllOrdersPage viewallorderspage = new ViewAllOrdersPage();

    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String string) {
      orderpage.navigateTo(string);
    }

    @When("user enters product information:")
    public void user_enters_product_information(List<Map<String,String>> dataTable) {
        for (Map<String, String> row : dataTable) {
            orderpage.selectProduct(row.get("Product"));
            orderpage.enterQuantity(row.get("Quantity"));
            orderpage.enterPricePerUnit(row.get("Price per unit"));
            orderpage.enterDiscount(row.get("Discount"));
        }
    }
    @When("user click on calculate button")
    public void user_click_on_calculate_button() {
      orderpage.clickToCalculate();
    }

    @Then("user should verify that total {int} is displayed")
    public void user_should_verify_that_total_is_displayed(int int1) {
        Assert.assertEquals( orderpage.totalDisplayed(),int1);
    }
    
    @When("user enters address information:")
    public void user_enters_address_information(List<Map<String,String>> dataTable) {
        for (Map<String, String> row : dataTable) {
             orderpage.enterCustomerName(row.get("Customer name"));
             orderpage.enterStreetName(row.get("Street"));
             orderpage.enterCityName(row.get("City"));
             orderpage.enterStateName(row.get("State"));
             orderpage.enterZip(row.get("Zip"));
        }
    }

    @When("user enters payment information:")
    public void user_enters_payment_information(List<Map<String,String>> dataTable) {
        for (Map<String, String> row : dataTable) {
             orderpage.enterCard(row.get("Card"));
             orderpage.enterCardNumber(row.get("Card Nr:"));
             orderpage.enterExpireDate(row.get("Expire date (mm//yy)"));
        }
    }

    @When("user click on process button")
    public void user_click_on_process_button() {
         orderpage.processBtn().click();
    }

    @Then("user verifies that order is displayed")
    public void user_verifies_that_order_is_displayed(List<Map<String,String>> dataTable) {
         orderpage.navigateTo("View all orders");
          for (Map<String, String> row : dataTable) {
             Assert.assertEquals(row.get("Customer name"),viewallorderspage.nameDisplay());
             Assert.assertEquals(row.get("Street"),viewallorderspage.streetDisplay());
             Assert.assertEquals(row.get("City"),viewallorderspage.cityDisplay());
             Assert.assertEquals(row.get("State"),viewallorderspage.stateDisplay());
             Assert.assertEquals(row.get("Zip"),viewallorderspage.zipDisplay());
        }
    }
}
