package com.pradeep.stepdefinitions;

import com.pradeep.data.UserData;
import com.pradeep.pages.CheckoutPage;
import com.pradeep.pages.DashBoardPage;
import com.pradeep.pages.HomePage;
import com.pradeep.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

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
        dashBoardPage.clickOnFirstItemFromSerchedResults(UserData.getInstance().getItemName());
        dashBoardPage.addToCart();
        dashBoardPage.clickOnShoppingCartMenu();
    }

    @When("User proceeds to checkout")
    public void userProceedsToCheckout() {
        new CheckoutPage()
                .agreeTermsAndConditions()
                .clickOnCheckout();
    }

    @And("User enters shipping and payment details")
    public void userEntersShippingAndPaymentDetails() {
        new CheckoutPage()
                .enterBillingAddressDetails
                        (UserData.getInstance().getCountry(),
                                UserData.getInstance().getCity(),
                                UserData.getInstance().getAddress(),
                                UserData.getInstance().getZipCode(),
                                UserData.getInstance().getMobNumber());
        new CheckoutPage().chooseShippingMode().choosePaymentMode();
    }

    @And("User confirms the order")
    public void userConfirmsTheOrder() {
        new CheckoutPage().confirmOrder();
    }


    @Then("User should see the order confirmation page")
    public void userShouldSeeTheOrderConfirmationPage() {
        Assertions.assertThat(new CheckoutPage().isOrderCompleted()).containsIgnoringCase("Your order has been successfully processed!");
    }

    @When("User navigates to the order history page")
    public void userNavigatesToTheOrderHistoryPage() {
        new CheckoutPage().clickOnMyAccount().clickOnOrders();
    }

    @And("User selects an order to view details")
    public void userSelectsAnOrderToViewDetails() {
        new CheckoutPage().viewOrderDetails();
    }

    @Then("User should see the order status")
    public void userShouldSeeTheOrderStatus() {
        Assertions.assertThat(new CheckoutPage().getOrderDetailsConfirmation()).containsIgnoringCase("Order");
    }
}
