package com.StepDefinitions;

import com.Utilities.DriverFactory;
import com.Utilities.RunConfiguration;
import com.Utilities.TempVariable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static RunConfiguration RunConfig;
    public static TempVariable Temp;
    public static void reset_Timeout() {

        driver.manage().timeouts().implicitlyWait(RunConfig.strImplicitWaitTimeout, TimeUnit.SECONDS);
    }

    @Before
    public WebDriver setUp() {

        RunConfig = new RunConfiguration();
        DriverFactory driverclass = new DriverFactory();
        Temp=new TempVariable();

        driver = driverclass.LaunchDriver(RunConfig.strBrowser,RunConfig.strOSName);
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, RunConfig.strImplicitWaitTimeout);
        return driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        driver.quit();
    }

}

