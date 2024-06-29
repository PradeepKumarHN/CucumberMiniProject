package com.pradeep.pages;

import com.pradeep.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


public class RegistrationPage extends BasePage{

    private final By successPrompt=By.xpath("//div[@class='result']");
    private final By userFirstName=By.xpath("//input[@id='FirstName']");
    private final By userLastName=By.xpath("//input[@id='LastName']");
    private final By userEmailID=By.xpath("//input[@id='Email']");
    private final By userPassword=By.xpath("//input[@id='Password']");
    private final By confirmPassword=By.xpath("//input[@id='ConfirmPassword']");
    private final By clickOnRegister=By.xpath("//button[@id='register-button']");
    private final By registerMenu=By.xpath("//a[@class='ico-register']");
    private final By alreadyRegisteredPrompt=By.xpath("//li[normalize-space()='The specified email already exists']");


    public String isRegistrationFormVisible(){
        clickOnElementWithJS(DriverManager.getDriver(),registerMenu);
         return DriverManager.getDriver().getTitle();
    }

    public RegistrationPage enterUserFirstName(String firstName) {
        sendKeysWithJS(DriverManager.getDriver(),userFirstName,firstName);
        return this;
    }

    public void enterUserLastName(String lastName) {
        sendKeysWithJS(DriverManager.getDriver(),userLastName,lastName);
    }

    public RegistrationPage enterEmailAddress(String emailId) {
        sendKeysWithJS(DriverManager.getDriver(),userEmailID,emailId);
        return this;
    }

    public void enterPassword(String password) {
        sendKeysWithJS(DriverManager.getDriver(),userPassword,password);
        sendKeysWithJS(DriverManager.getDriver(),confirmPassword,password);
    }

    public void clickOnRegister() {
        clickOnElementWithJS(DriverManager.getDriver(),clickOnRegister);
    }

    public String isRegisteredSuccessful() {
        String prompt= "";
        try {
            prompt=DriverManager.getDriver().findElement(successPrompt).getText();
        }catch (NoSuchElementException e) {
            prompt=DriverManager.getDriver().findElement(alreadyRegisteredPrompt).getText();
        }
        return prompt;
    }
}
