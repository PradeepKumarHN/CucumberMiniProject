package com.pradeep.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.pradeep.stepdefinitions"},
        plugin = {"pretty", "html:target/html/cucumber-reports.html", "json:target/json/cucumber.json"},
        monochrome = true,
        dryRun = false,
        tags="@Login",
        publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

/*    public static void main(String[] args) throws InterruptedException {
        System.out.println(PropertyUtils.getProperty(PropertyType.URL));
        System.out.println(ExcelUtils.readExcel("C:\\Users\\prdp4\\IdeaProjects\\CucumberMiniProject\\src\\test\\resources\\testdata\\controller.xlsx",
                "tests"));
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("www.google.com");
        Thread.sleep(5000);
        driver.quit();
    }*/
}