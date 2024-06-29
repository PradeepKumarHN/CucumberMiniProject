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

import java.util.List;
import java.util.Map;

public class DashBoardSteps {
    @Given("User is on the e-commerce account homepage")
    public void userIsOnTheECommerceAccountHomepage() {
        String path="C:\\Users\\prdp4\\IdeaProjects\\CucumberMiniProject\\src\\test\\resources\\testdata\\controller.xlsx";
        List<Map<Object,Object>> list=ExcelUtils.readExcel(path,"tests");
        String userAccount= (String) list.get(0).get("userAccount");
        String password=(String) list.get(0).get("password");
        String item=(String) list.get(0).get("item-name");
        new HomePage().clickOnLoginMenu();
        new LoginPage().enterUserID(userAccount).enterPassword(password).clickOnLoginButton();
    }

    @When("User enters {string} in the search bar")
    public void userEntersInTheSearchBar(String itemName) {
        new DashBoardPage().EnterItemToSearch(itemName);
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
}
