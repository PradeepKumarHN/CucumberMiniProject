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

public class ShoppingCartSteps {

    @Given("the user has searched for items")
    public void theUserHasSearchedForItems() {
        new HomePage().clickOnLoginMenu();
        new LoginPage().enterUserID(UserData.getInstance().getUserAccount())
                .enterPassword(UserData.getInstance().getPassword()).clickOnLoginButton();
        new DashBoardPage().searchResults(UserData.getInstance().getItemName());
    }

    @When("the user selects an item from the search results")
    public void theUserSelectsAnItemFromTheSearchResults() {
        new DashBoardPage().clickOnFirstItemFromSerchedResults(UserData.getInstance().getItemName());
    }

    @And("the user clicks on the Add to Cart button")
    public void theUserClicksOnTheAddToCartButton() {
        new DashBoardPage().addToCart();
    }

    @Then("the item should be added to the shopping cart")
    public void theItemShouldBeAddedToTheShoppingCart() {
        Assertions.assertThat(new DashBoardPage().isItemAddedIntoShoppingCart()).isTrue();
    }
}
