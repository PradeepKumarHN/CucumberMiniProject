package com.pradeep.pages;

import com.pradeep.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashBoardPage extends BasePage {

    private final By logoutOption = By.xpath("//a[normalize-space()='Log out']");

    private final By searchTextbox = By.xpath("//input[@id='small-searchterms']");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");

    private static String searchWithKeywords = "//div[@class='search-results']//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]";
    private final By searchedItem1 = By.xpath("//div[@class=\"product-item\"]//h2");

    private final By searchedItem1ProductDetails = By.xpath("//div[@class='search-results']//a[contains(text(),'Lenovo')]");

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

    public boolean clickOnFirstItemFromSerchedResults() {
        try {
            clickOnElementWithJS(DriverManager.getDriver(), searchedItem1);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isDetailsOfFirstItemFromSerchedResultsVisible() {
        return DriverManager.getDriver().findElements(searchedItem1ProductDetails).size() == 1;
    }
}
