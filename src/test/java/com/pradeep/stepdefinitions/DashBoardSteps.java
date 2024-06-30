package com.pradeep.stepdefinitions;

import com.pradeep.data.UserData;
import com.pradeep.pages.DashBoardPage;
import com.pradeep.pages.HomePage;
import com.pradeep.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;


public class DashBoardSteps {

    @Given("User is on the e-commerce account homepage")
    public void userIsOnTheECommerceAccountHomepage() {
        new HomePage().clickOnLoginMenu();
        new LoginPage().enterUserID(UserData.getInstance().getUserAccount())
                .enterPassword(UserData.getInstance().getPassword()).clickOnLoginButton();
    }

    @When("User enters {string} in the search bar")
    public void userEntersInTheSearchBar(String itemName) {
        new DashBoardPage().enterItemToSearch(itemName);
    }

    @And("User clicks on the search button")
    public void userClicksOnTheSearchButton() {
        new DashBoardPage().searchItem();
    }

    @Then("User should see search results for {string}")
    public void userShouldSeeSearchResultsFor(String itemName) {
        boolean itemSearched=new DashBoardPage().searchWithKeywords(itemName);
        Assertions.assertThat(itemSearched).isTrue();
    }

    @Given("User is on the search results page")
    public void userIsOnTheSearchResultsPage() {
        new DashBoardPage().enterItemToSearch(UserData.getInstance().getItemName()).searchItem();
    }

    @When("User checks the availability of an item")
    public void userChecksTheAvailabilityOfAnItem() {
        new DashBoardPage().searchResults(UserData.getInstance().getItemName());
    }

    @Then("User should see if the item is available")
    public void userShouldSeeIfTheItemIsAvailable() {
        Assertions.assertThat(new DashBoardPage().searchResults(UserData.getInstance().getItemName())).isTrue();
    }

    @When("User clicks on an item")
    public void userClicksOnAnItem() {
        new DashBoardPage().clickOnFirstItemFromSerchedResults(UserData.getInstance().getItemName());
    }

    @Then("User should see the item details page")
    public void userShouldSeeTheItemDetailsPage() {
        Assertions.assertThat(new DashBoardPage().isDetailsOfFirstItemFromSerchedResultsVisible(UserData.getInstance().getItemName())).isTrue();
    }
}
