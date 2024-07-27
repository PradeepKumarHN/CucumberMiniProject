package com.pradeep.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.pradeep.stepdefinitions"},
        tags = "@Logout",
        plugin = {"pretty", "html:target/html/cucumber-reports-Logout.html", "json:target/json/cucumber-Logout.json"},
        monochrome = true
)
public class LogoutRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}