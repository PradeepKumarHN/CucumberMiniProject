package com.pradeep.factory;

import com.pradeep.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {
    private DriverFactory() {
    }

    private static final Map<BrowserType, Supplier<WebDriver>> driverMap = new HashMap<>();

    static {
        driverMap.put(BrowserType.CHROME, () -> {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        });
        driverMap.put(BrowserType.FIREFOX, () -> {
            WebDriverManager.firefoxdriver().clearResolutionCache();
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        });
        driverMap.put(BrowserType.EDGE, () -> {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        });
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return driverMap.getOrDefault(browserType, driverMap.get(BrowserType.CHROME)).get();
    }
}
