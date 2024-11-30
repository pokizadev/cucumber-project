package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDef {

    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {

//        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib27_user"));
//        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib27_pass"));
//        loginPage.signinBtn.click();

        loginPage.login(ConfigurationReader.getProperty("lib27_user"), ConfigurationReader.getProperty("lib27_pass"));
    }

    @Then ("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        BrowserUtils.sleep(3);

        String expectedUrl = "dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @When("I login as a student")
    public void iLoginAsAStudent() {
        loginPage.login(ConfigurationReader.getProperty("student27_user"), ConfigurationReader.getProperty("student27_pass"));
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("books"));
    }
}
