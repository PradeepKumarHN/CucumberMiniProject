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
        new DashBoardPage().enterItemToSearch(UserData.getInstance().getItemName()).searchItem();
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

    @Given("the user is viewing the shopping cart")
    public void theUserIsViewingTheShoppingCart() {
        new HomePage().clickOnLoginMenu();
        new LoginPage().enterUserID(UserData.getInstance().getUserAccount())
                .enterPassword(UserData.getInstance().getPassword()).clickOnLoginButton();
        DashBoardPage dashBoardPage=new DashBoardPage();
        dashBoardPage.enterItemToSearch(UserData.getInstance().getItemName()).searchItem();
        dashBoardPage.clickOnFirstItemFromSerchedResults(UserData.getInstance().getItemName());
        dashBoardPage.addToCart();
        dashBoardPage.clickOnShoppingCartMenu();
    }

    @When("the user changes the quantity of an item to {string}")
    public void theUserChangesTheQuantityOfAnItemTo(String qty) {
        new DashBoardPage().editQuantityOfTheItem(qty);
    }

    @Then("the shopping cart should be updated with the new quantity {string}")
    public void theShoppingCartShouldBeUpdatedWithTheNewQuantity(String qty) {
        Assertions.assertThat(new DashBoardPage().isEditedItemIncreasedQty(qty)).isTrue();
    }

    @When("the user clicks on the Remove button for an item")
    public void theUserClicksOnTheRemoveButtonForAnItem() {


        new DashBoardPage().deleteItemFromShoppingCart();
    }

    @Then("the item should be removed from the shopping cart")
    public void theItemShouldBeRemovedFromTheShoppingCart() {
        Assertions.assertThat(new DashBoardPage().isItemDeleted()).isTrue();
    }
}
