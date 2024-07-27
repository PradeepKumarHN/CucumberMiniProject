package com.pradeep.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.pradeep.stepdefinitions"},
        tags = "@Checkout",
        plugin = {"pretty", "html:target/html/cucumber-reports-Checkout.html", "json:target/json/cucumber-Checkout.json"},
        monochrome = true
)
public class CheckoutRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
