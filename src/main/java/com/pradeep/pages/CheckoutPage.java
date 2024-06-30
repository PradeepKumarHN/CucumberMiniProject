package com.pradeep.pages;

import com.pradeep.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    private final By termsAndConditions=By.xpath("//input[@id='termsofservice']");

    private final By clickOnCheckout=By.xpath("//button[@id='checkout']");

    private final By countrySelect=By.xpath("//select[@id='BillingNewAddress_CountryId']");

    private final By cityName=By.xpath("//input[@id='BillingNewAddress_City']");
    private final By address=By.xpath("//input[@id='BillingNewAddress_Address1']");

    private final By zip=By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    private final By phoneNum=By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    private final By continueAfterBillingAddress=By.xpath("//button//following-sibling::button[@class=\"button-1 new-address-next-step-button\"]");

    public CheckoutPage agreeTermsAndConditions(){
        if(!DriverManager.getDriver().findElement(termsAndConditions).isSelected()){
            clickOnElementWithJS(DriverManager.getDriver(),termsAndConditions);
        }
        return this;
    }

    public CheckoutPage clickOnCheckout() {
        if(!DriverManager.getDriver().findElement(termsAndConditions).isSelected()){
            clickOnElementWithJS(DriverManager.getDriver(),clickOnCheckout);
        }
        return this;
    }
    public CheckoutPage enterBillingAddressDetails(String country,String city,String address1,String zipcode,String phoneNumber){
        Select select=new Select(DriverManager.getDriver().findElement(countrySelect));
        select.selectByVisibleText(country);
        sendKeysWithJS(DriverManager.getDriver(),cityName,city);
        sendKeysWithJS(DriverManager.getDriver(),address,address1);
        sendKeysWithJS(DriverManager.getDriver(),zip,zipcode);
        sendKeysWithJS(DriverManager.getDriver(),phoneNum,phoneNumber);
        clickOnElementWithJS(DriverManager.getDriver(),continueAfterBillingAddress);
        return this;
    }
}
