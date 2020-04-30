package com.weborders.step_definitions;

import com.weborders.pages.LoginPage;
import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

  LoginPage loginpage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
    }

    @When("user logs in as tester")
    public void user_logs_in_as_tester() {
        loginpage.login();
    }
    @Then("user should verify logo page")
    public void user_should_verify_logo_page() {
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals( loginpage.getPageLogoText(),"Web Orders");
    }

}
