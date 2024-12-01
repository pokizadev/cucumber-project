package com.cydeo.step_definitions;

import com.cydeo.pages.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Users_StepDef {

    UsersPage usersPage = new UsersPage();

    @Given("I click on {string} link")
    public void i_click_on_link(String string) {
        usersPage.usersLink.click();
    }
    @Then("table should have following columns:")
    public void table_should_have_following_columns(List<String> expectedHeaders) {
        List<String> actualHeaders = new ArrayList<>();

        for(WebElement eachHeader : usersPage.tableHeaders) {
            actualHeaders.add(eachHeader.getText());
        }

        Assert.assertEquals(expectedHeaders, actualHeaders);
    }
}
