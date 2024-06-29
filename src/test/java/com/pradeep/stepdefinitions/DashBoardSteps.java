package com.pradeep.stepdefinitions;

import com.pradeep.pages.DashBoardPage;
import com.pradeep.pages.HomePage;
import com.pradeep.pages.LoginPage;
import com.pradeep.utils.ExcelUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashBoardSteps {
    private static Map<String,String> data=new HashMap<>();
    @Given("User is on the e-commerce account homepage")
    public void userIsOnTheECommerceAccountHomepage() {
        String path="C:\\Users\\prdp4\\IdeaProjects\\CucumberMiniProject\\src\\test\\resources\\testdata\\controller.xlsx";
        List<Map<Object,Object>> list=ExcelUtils.readExcel(path,"tests");
        data.put("userAccount",(String) list.get(0).get("userAccount"));
        data.put("password",(String) list.get(0).get("password"));
        data.put("item-name",(String) list.get(0).get("item-name"));
        new HomePage().clickOnLoginMenu();
        new LoginPage().enterUserID(data.get("userAccount")).enterPassword(data.get("password")).clickOnLoginButton();
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
        new DashBoardPage().enterItemToSearch(data.get("item-name")).searchItem();
    }

    @When("User checks the availability of an item")
    public void userChecksTheAvailabilityOfAnItem() {
        new DashBoardPage().searchResults(data.get("item-name"));
    }

    @Then("User should see if the item is available")
    public void userShouldSeeIfTheItemIsAvailable() {
        Assertions.assertThat(new DashBoardPage().searchResults(data.get("item-name"))).isTrue();
    }

    @When("User clicks on an item")
    public void userClicksOnAnItem() {
        new DashBoardPage().clickOnFirstItemFromSerchedResults(data.get("item-name"));
    }

    @Then("User should see the item details page")
    public void userShouldSeeTheItemDetailsPage() {
        Assertions.assertThat(new DashBoardPage().isDetailsOfFirstItemFromSerchedResultsVisible(data.get("item-name"))).isTrue();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
