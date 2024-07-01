package com.pradeep.stepdefinitions;

import com.pradeep.pages.CheckoutPage;
import com.pradeep.pages.DashBoardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class LogoutSteps {

    @When("the user clicks on the logout button")
    public void theUserClicksOnTheLogoutButton() {
        new DashBoardPage().clickOnLogout();
    }


    @Then("the user should be logged out")
    public void theUserShouldBeLoggedOut() {
        Assertions.assertThat(new DashBoardPage().isLoggedOutSuccessfully()).isTrue();
    }
}
