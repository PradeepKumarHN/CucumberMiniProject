package com.pradeep.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.pradeep.stepdefinitions"},
        tags = "@ItemManage",
        plugin = {"pretty", "html:target/html/cucumber-reports-DashboardRunner.html", "json:target/json/cucumber-DashboardRunner.json"},
        monochrome = true
)
public class DashboardRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}