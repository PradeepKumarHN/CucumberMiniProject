package com.pradeep.stepdefinitions;

import com.pradeep.driver.DriverManager;
import com.pradeep.enums.BrowserType;
import com.pradeep.enums.PropertyType;
import com.pradeep.factory.DriverFactory;
import com.pradeep.utils.PropertyUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.SourceMediaType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

public class TestBase {
    @Before
    public void setup(){
        if(Objects.isNull(DriverManager.getDriver())) {
            String browser = PropertyUtils.getProperty(PropertyType.BROWSER);
            DriverManager.setDriver(DriverFactory.getDriver(BrowserType.valueOf(browser.toUpperCase())));
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().get(PropertyUtils.getProperty(PropertyType.URL));
        }
    }
    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
            try (FileOutputStream destintedFile = new FileOutputStream(System.getProperty("user.dir")
                    + "/src/test/resources/failedscreenshots/" +scenario.getName()+"_"+System.currentTimeMillis() +".jpg")) {
                scenario.attach(screenshot.getScreenshotAs(OutputType.BYTES), "image/png", "Failed Screenshot");
                Files.copy(screenshot.getScreenshotAs(OutputType.FILE).toPath(), destintedFile);
            } catch (FileNotFoundException e) {
                scenario.log(Arrays.toString(e.getStackTrace()));
                throw new RuntimeException(e);
            } catch (IOException e) {
                scenario.log(Arrays.toString(e.getStackTrace()));
                throw new RuntimeException(e);
            }
        }
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
