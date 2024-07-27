package com.pradeep.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.pradeep.stepdefinitions"},
        tags = "@ShoppingCart",
        plugin = {"pretty", "html:target/html/cucumber-reports-ShoppingCart.html", "json:target/json/cucumber-ShoppingCart.json"},
        monochrome = true
)
public class ShoppingCartRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}