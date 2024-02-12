package com.ideyalabs.common;

import com.ideyalabs.driver.DriverManager;
import com.ideyalabs.driver.TargetFactory;
import com.ideyalabs.helpers.PropertiesHelpers;
import com.ideyalabs.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest {
    @Parameters("BROWSER")
    @BeforeMethod
    public void createDriver(@Optional("chrome") String browser) {
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        DriverManager.quit();
    }

    public WebDriver createBrowser(@Optional("chrome") String browser) {
        PropertiesHelpers.loadAllFiles();
        WebDriver driver = ThreadGuard.protect(new TargetFactory().createInstance(browser));
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        return DriverManager.getDriver();
    }

}
