package com.pradeep.stepdefinitions;

import com.pradeep.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.NoSuchElementException;

public class RegisterSteps {
    @Given("I am on the NopCommerce registration page")
    public void iAmOnTheNopCommerceRegistrationPage() {
        String title=new RegistrationPage().isRegistrationFormVisible();
        Assertions.assertThat(title).containsIgnoringCase("nopCommerce demo store. Register");
    }

    @When("I enter user first name {} and last name {}")
    public void iEnterUserFirstNameAndLastName(String firstName, String lastName) {
        new RegistrationPage().enterUserFirstName(firstName).enterUserLastName(lastName);
    }

    @And("I enter the email {string} the password {string}")
    public void iEnterTheEmailThePassword(String emailId, String password) {
        new RegistrationPage().enterEmailAddress(emailId).enterPassword(password);
    }

    @And("I click on the register button")
    public void iClickOnTheRegisterButton() {
        new RegistrationPage().clickOnRegister();
    }

    @Then("I should see a registration success message")
    public void iShouldSeeARegistrationSuccessMessage() {
            String registered = new RegistrationPage().isRegisteredSuccessful();
            Assertions.assertThat(registered).satisfiesAnyOf(
                message -> Assertions.assertThat(message).containsIgnoringCase("Your registration completed"),
                message -> Assertions.assertThat(message).containsIgnoringCase("The specified email already exists")
            );
    }
}
