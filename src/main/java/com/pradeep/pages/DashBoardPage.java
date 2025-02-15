package com.pradeep.pages;

import com.pradeep.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashBoardPage extends BasePage {

    private final By logoutOption = By.xpath("//a[normalize-space()='Log out']");
    private final By loginOption = By.xpath("//a[normalize-space()='Log in']");


    private final By searchTextbox = By.xpath("//input[@id='small-searchterms']");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");

    private static String searchWithKeywords = "//div[@class='search-results']//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]";

    private static String searchedItem1ProductDetails ="//form[@id='product-details-form']//h1[contains(text(),'%s')]";
    private final By addToCart = By.xpath("//div[@class='add-to-cart']//button[text()='Add to cart']");

    private final By shoppingCartItem = By.xpath("//table//a[normalize-space()='Lenovo Thinkpad X1 Carbon Laptop']");

    private final By clickOnShoppingCart = By.xpath("//span[@class='cart-label']");
    private final By itemQty=By.xpath("//div[@class=\"product-quantity\"]//input");
    private final By deleteItemFromCart=By.xpath("//button[@class='remove-btn']");

    public boolean isLoggedInSuccessfully() {
        return DriverManager.getDriver().findElement(logoutOption).isEnabled();
    }

    public DashBoardPage enterItemToSearch(String itemToSearch) {
        clickOnElementWhenItsClickable(DriverManager.getDriver(), searchTextbox);
        sendKeysWhenElementIsVisible(DriverManager.getDriver(), searchTextbox, itemToSearch);
        return this;
    }

    public void searchItem() {
        clickOnElementWithJS(DriverManager.getDriver(), searchButton);
    }

    public boolean searchResults(String item) {
        List<WebElement> elements=DriverManager.getDriver().findElements(By.partialLinkText(item));
        List<String> textList = new ArrayList<>();
        for(WebElement ele:elements){
            textList.add(ele.getText());
        }
        return textList.contains(item);
    }


    public boolean searchWithKeywords(String searchKeyword) {
        List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath(String.format(searchWithKeywords, searchKeyword.toLowerCase())));
        List<String> textList = new ArrayList<>();
        for(WebElement ele:elements){
            textList.add(ele.getText());
        }
        boolean status=textList.isEmpty();
        return !status;
    }

    public boolean clickOnFirstItemFromSerchedResults(String item) {
        try {
            clickOnElementWithJS(DriverManager.getDriver(), By.partialLinkText(item));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isDetailsOfFirstItemFromSerchedResultsVisible(String item) {
        String itemSearch=searchedItem1ProductDetails.replace("%s",item);
        return DriverManager.getDriver().findElements(By.xpath(itemSearch)).size() == 1;
    }

    public void addToCart(){
        clickOnElementWithJS(DriverManager.getDriver(),addToCart);
    }
    public boolean isItemAddedIntoShoppingCart(){
        clickOnElementWithJS(DriverManager.getDriver(),clickOnShoppingCart);
        return DriverManager.getDriver().findElement(shoppingCartItem).isDisplayed();
    }

    public void clickOnShoppingCartMenu() {
        clickOnElementWithJS(DriverManager.getDriver(),clickOnShoppingCart);
    }
    public void editQuantityOfTheItem(String qty){
        sendKeysWithJS(DriverManager.getDriver(),itemQty,qty);
    }
    public boolean isEditedItemIncreasedQty(String qty){
        String qtyFound=DriverManager.getDriver().findElement(itemQty).getAttribute("value");
        return qtyFound.equalsIgnoreCase(qty);
    }

    public void deleteItemFromShoppingCart() {
        clickOnElementWithJS(DriverManager.getDriver(),deleteItemFromCart);
    }

    public boolean isItemDeleted() {
         try {
             DriverManager.getDriver().findElement(deleteItemFromCart);
         }
         catch (NoSuchElementException e){return true;
         }return false;
    }

    public void clickOnLogout(){
        clickOnElementWithJS(DriverManager.getDriver(),logoutOption);
    }

    public boolean isLoggedOutSuccessfully(){
        return new WebDriverWait(DriverManager.getDriver() , Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(loginOption)).isDisplayed();
    }

}
