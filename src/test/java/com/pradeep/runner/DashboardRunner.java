package com.pradeep.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.pradeep.stepdefinitions"},
        tags = "@ItemManage",
        plugin = {"pretty", "html:target/cucumber-reports-DashboardRunner.html", "json:target/cucumber-DashboardRunner.json"},
        monochrome = true
)
public class DashboardRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}