package com.pradeep.stepdefinitions;

import com.pradeep.data.UserData;
import com.pradeep.pages.CheckoutPage;
import com.pradeep.pages.DashBoardPage;
import com.pradeep.pages.HomePage;
import com.pradeep.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    @Given("User is on e-commerce account homepage")
    public void userIsOnTheECommerceAccountHomepage() {
        new HomePage().clickOnLoginMenu();
        new LoginPage().enterUserID(UserData.getInstance().getUserAccount()).enterPassword(UserData.getInstance().getPassword()).clickOnLoginButton();
    }

    @And("User has items in the shopping cart")
    public void userHasItemsInTheShoppingCart() {
        DashBoardPage dashBoardPage= new DashBoardPage();
        dashBoardPage.enterItemToSearch(UserData.getInstance().getItemName()).searchItem();
        dashBoardPage.addToCart();
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        new CheckoutPage()
                .agreeTermsAndConditions()
                .clickOnCheckout();
    }
}
