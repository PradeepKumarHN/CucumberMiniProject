package com.pradeep.pages;

import com.pradeep.driver.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By loginMenu = By.xpath("//a[text()='Log in']");

    public HomePage clickOnLoginMenu() {
        clickOnElementWhenItsClickable(DriverManager.getDriver(), loginMenu);
        return this;
    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
