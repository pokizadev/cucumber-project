package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Dashboard_StepDef {

    DashboardPage dashboardPage = new DashboardPage();

    @And("there should be {int} users")
    public void thereShouldBeUsers(int expectedUserAmount) {

        BrowserUtils.waitForVisibility(dashboardPage.userAmount, 10);
        BrowserUtils.sleep(3);
        String actualUserAmount = dashboardPage.userAmount.getText();
        String expectedUserCount = String.valueOf(expectedUserAmount); // expectedUserAmount+""; we can use by this way as well;

        Assert.assertEquals(expectedUserCount, actualUserAmount);
    }
}
