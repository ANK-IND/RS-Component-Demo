package com.Pages;

import com.StepDefinitions.Hooks;
import com.cucumber.listener.Reporter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public static WebDriver driver = Hooks.driver;
    public static WebDriverWait wait = Hooks.wait;

    public static By popUpSurvey = By.cssSelector("a.acsInviteButton.acsDeclineButton");
    public static By btnNoThanks = By.xpath("//*[@id='acsMainInvite']/div/a[1]");



    public static void alert_Handling(String value) {
        try {
            Alert alert = driver.switchTo().alert();
            if (value.contains("Yes"))
                alert.accept();
            else if (value.contains("No")) {
                alert.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void launchHomepage() {
        try {

            driver.get(Hooks.RunConfig.strurl);
            driver.getCurrentUrl();
            if (driver.findElement(HomePage.bnrCookies).isDisplayed()) {
                driver.findElement(HomePage.btnAcceptCoookies).click();
                Reporter.addStepLog("User in Homepage");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void drop_Down(WebElement dropdowname, String dropdownvalue) {
        try {
            Select dd = new Select(dropdowname);
            dd.selectByValue(dropdownvalue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void closeSurvey() {
        try {
            if (driver.findElement(btnNoThanks).isDisplayed()) {
                driver.findElement(btnNoThanks).click();
                Reporter.addStepLog("Survey Pop Up closed successfully");
            } else {
                Reporter.addStepLog("No Survey Pop Up found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}