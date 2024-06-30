package com.pradeep.stepdefinitions;

import com.pradeep.data.UserData;
import com.pradeep.pages.DashBoardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class ShoppingCartSteps {

    @Given("the user has searched for items")
    public void theUserHasSearchedForItems() {
        new DashBoardPage().searchResults(UserData.getInstance().getItemName());
    }
}
