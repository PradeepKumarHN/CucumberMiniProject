package com.pradeep.pages;

import com.pradeep.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {
    private final By termsAndConditions = By.xpath("//input[@id='termsofservice']");

    private final By clickOnCheckout = By.xpath("//button[@id='checkout']");

    private final By countrySelect = By.xpath("//select[@id='BillingNewAddress_CountryId']");

    private final By cityName = By.xpath("//input[@id='BillingNewAddress_City']");
    private final By address = By.xpath("//input[@id='BillingNewAddress_Address1']");

    private final By zip = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    private final By phoneNum = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    private final By continueAfterBillingAddress = By.xpath("//button//following-sibling::button[@class=\"button-1 new-address-next-step-button\"]");
    private final By continueWithShippingMode=By.xpath("//form//button[text()='Continue']");
    private final By continueWithPaymentMode=By.xpath("//form[@id=\"co-payment-method-form\"]//following::button");
    private final By continueWithCoPaymentMode=By.xpath("//form[@id=\"co-payment-info-form\"]//following::button");
    private final By editAddress=By.xpath("//button[@id=\"edit-billing-address-button\"]");
    private final By confirmFinalOrder=By.xpath("//div[@id=\"confirm-order-buttons-container\"]//button");
    private final By orderConfirmationMessage=By.xpath("//div[@class=\"section order-completed\"]//strong");

    public CheckoutPage agreeTermsAndConditions() {
        if (!DriverManager.getDriver().findElement(termsAndConditions).isSelected()) {
            clickOnElementWithJS(DriverManager.getDriver(), termsAndConditions);
        }
        return this;
    }

    public CheckoutPage clickOnCheckout() {
        clickOnElementWithJS(DriverManager.getDriver(), clickOnCheckout);
        return this;
    }

    public CheckoutPage enterBillingAddressDetails(String country, String city, String address1, String zipcode, String phoneNumber) {
        try {
            clickOnElementWhenItsClickable(DriverManager.getDriver(), editAddress);
        }catch (NoSuchElementException e){
            System.out.println("Since existing address not updated adding new address");
        }
        clickOnElementWhenItsClickable(DriverManager.getDriver(),countrySelect);
        Select select = new Select(DriverManager.getDriver().findElement(countrySelect));
        select.selectByVisibleText(country);
        sendKeysWithJS(DriverManager.getDriver(), cityName, city);
        sendKeysWithJS(DriverManager.getDriver(), address, address1);
        sendKeysWithJS(DriverManager.getDriver(), zip, zipcode);
        sendKeysWithJS(DriverManager.getDriver(), phoneNum, phoneNumber);
        clickOnElementWithJS(DriverManager.getDriver(), continueAfterBillingAddress);
        return this;
    }

    public CheckoutPage chooseShippingMode(){
        clickOnElementWithJS(DriverManager.getDriver(), continueWithShippingMode);
        return this;
    }
    public CheckoutPage choosePaymentMode(){
        clickOnElementWithJS(DriverManager.getDriver(), continueWithPaymentMode);
        clickOnElementWithJS(DriverManager.getDriver(), continueWithCoPaymentMode);
        return this;
    }


    public CheckoutPage confirmOrder(){
        clickOnElementWithJS(DriverManager.getDriver(), confirmFinalOrder);
        return this;
    }
    public String isOrderCompleted(){
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage)).getText();
    }
}
