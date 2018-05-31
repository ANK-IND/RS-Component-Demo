package com.Utilities;

import com.StepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class DriverFactory {


    public String driverPath;
    public WebDriver driver;

    public WebDriver LaunchDriver(String browser, String osName) {

        String browser1 = browser.toUpperCase();

        String currentDir = System.getProperty("user.dir");
        driverPath = currentDir + "/DriverFiles";
        //System.out.println(driverPath);
        switch (browser1) {

            case "CHROME":

                if (osName.equalsIgnoreCase("Windows")) {
                    System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                } else
                    System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
                    driver = new ChromeDriver();
                    break;

            case "FIREFOX":
                if (osName.equalsIgnoreCase("Windows")) {
                    System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver.exe");
                    FirefoxOptions optionsFF = new FirefoxOptions();
                    optionsFF = FF_capability();
                    driver = new FirefoxDriver(optionsFF);
                    break;
                } else
                System.setProperty("webdriver.gecko.driver", driverPath + "/geckodriver");
                FirefoxOptions optionsFF = new FirefoxOptions();
                optionsFF = FF_capability();
                driver = new FirefoxDriver(optionsFF);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Hooks.RunConfig.strImplicitWaitTimeout, TimeUnit.SECONDS);
        return driver;

    }


    private FirefoxOptions FF_capability() {

        FirefoxOptions optionsFF = new FirefoxOptions();

        optionsFF.setAcceptInsecureCerts(true);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 0);
        optionsFF.setProfile(profile);

        return optionsFF;
    }

}
