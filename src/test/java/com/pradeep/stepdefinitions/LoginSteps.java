package com.pradeep.stepdefinitions;

import com.pradeep.driver.DriverManager;
import com.pradeep.pages.HomePage;
import com.pradeep.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class LoginSteps{

    @Given("User is on the NopCommerce homepage")
    public void userIsOnTheNopCommerceHomepage() {
        Assertions.assertThat(new HomePage().getTitle()).containsIgnoringCase("nopCommerce demo store");
    }

    @When("User clicks on the login menu")
    public void userClicksOnTheLoginMenu() {
        new HomePage().clickOnLoginMenu();
    }

    @Given("User is on the NopCommerce login page")
    public void userIsOnTheNopCommerceLoginPage() {
        Assertions.assertThat(new LoginPage().getLoginPageUrl()).contains("https://demo.nopcommerce.com/login");
    }

    @When("User enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        new LoginPage().enterUserID(username).enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        Assertions.assertThat(new LoginPage().getTitle()).containsIgnoringCase("nopCommerce demo store");
    }

    @Then("User should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String errorMessage) {
        String err=DriverManager.getDriver().findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assertions.assertThat(err).containsIgnoringCase(errorMessage);
    }

}

