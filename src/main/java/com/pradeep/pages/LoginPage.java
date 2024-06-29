package com.pradeep.pages;

import com.pradeep.driver.DriverManager;
import org.openqa.selenium.By;


public class LoginPage extends BasePage{

    private final By userId=By.xpath("//input[@id='Email']");
    private final By password=By.xpath("//input[@id='Password']");
    private final By loginButton=By.xpath("//button[normalize-space()='Log in']");
    public LoginPage enterUserID(String userID){
        sendKeysWithJS(DriverManager.getDriver(),userId,userID);
        return this;
    }
    public LoginPage enterPassword(String password){
        sendKeysWithJS(DriverManager.getDriver(),this.password,password);
        return this;
    }
    public void clickOnLoginButton(){
        clickOnElementWhenItsClickable(DriverManager.getDriver(),this.loginButton);
    }
    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }

    public String getLoginPageUrl(){
        return DriverManager.getDriver().getCurrentUrl();
    }
    private final By logoutOption = By.xpath("//a[normalize-space()='Log out']");
    public boolean isLoggedInSuccessfully(){
        return DriverManager.getDriver().findElement(logoutOption).isEnabled();
    }
}
