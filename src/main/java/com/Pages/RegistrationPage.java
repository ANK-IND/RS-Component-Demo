package com.Pages;

import com.StepDefinitions.Hooks;
import com.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;
import java.util.Random;

public class RegistrationPage extends BasePage{


    public static By txtUsername = By.id("credential.username");
    public static By txtPassword = By.id("password");
    public static By txtRetypePwd = By.id("confirmPassword");
    public static By btnRSaccount = By.id("js-accountCustomerCloseBtn");
    public static By ddTitle = By.id("name.title");
    public static By txtFirstname = By.id("name.firstName");
    public static By txtSurname = By.id("name.surname");
    public static By txtTelephone = By.id("telephone");
    public static By txtEmailAddress = By.id("email");
    public static By txtJobTitle = By.id("jobTitle");
    public static By dd_role = By.id("jobFunction");
    public static By dd_HearAboutUs = By.id("hearAbout");
    public static By chkboxEmail = By.id("marketingEmail");
    public static By chkboxPhone = By.id("marketingAllowedByPhone");
    public static By btnRegister = By.id("register-button");


    public static void clickRegistration() {
        try {

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(HomePage.lnkRegister)));
            if (driver.findElement(HomePage.lnkRegister).isDisplayed()) {
                driver.findElement(HomePage.lnkRegister).click();
            } else {
                System.out.println("User not in homepage,Please try again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verifyPageNavigation() {
        try {
            String strPageTile = driver.getCurrentUrl();
            Assert.assertTrue(strPageTile.contains("register/registration"));
            Reporter.addStepLog("User navigated to Registration Page Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void enterUserDetails(DataTable userDetails) {
        try {
            String strPageTile = driver.getCurrentUrl();
            Assert.assertTrue(strPageTile.contains("register/registration"));
            for (Map<String, String> data : userDetails.asMaps(String.class, String.class)) {


                Random ran = new Random();
                ran.nextInt(10000);
                String ran1 = String.valueOf(ran.nextInt(10000));
                String name = data.get("Username") + ran1;
                Hooks.Temp.setUserName(name);
                Reporter.addStepLog("UserName:"+name);

                driver.findElement(txtUsername).sendKeys(name);
                driver.findElement(txtPassword).sendKeys(data.get("Password"));
                driver.findElement(txtRetypePwd).sendKeys(data.get("RetypePwd"));
                driver.findElement(btnRSaccount).click();
                //Selecting Title Drop down
                WebElement drop_down = driver.findElement(ddTitle);
                BasePage.drop_Down(drop_down, data.get("Title"));
                driver.findElement(txtFirstname).sendKeys(data.get("First_name"));
                driver.findElement(txtSurname).sendKeys(data.get("Surname"));
                driver.findElement(txtTelephone).sendKeys(data.get("Phone"));
                String ran2 = String.valueOf(ran.nextInt(10000));
                String[] email = data.get("Email").split("@");
                String email1 = email[0] + ran2 + '@' + email[1];
                Reporter.addStepLog("Email Address Registered:"+email1);

                driver.findElement(txtEmailAddress).sendKeys(email1);
                driver.findElement(txtJobTitle).sendKeys(data.get("Job_Title"));
                //Selecting Role Drop down
                WebElement drop_down1 = driver.findElement(dd_role);
                BasePage.drop_Down(drop_down1, data.get("Role"));
                //Selecting Hear About Drop down
                WebElement drop_down2 = driver.findElement(dd_HearAboutUs);
                BasePage.drop_Down(drop_down2, data.get("Hear_About"));
                driver.findElement(chkboxEmail).click();
                driver.findElement(chkboxPhone).click();
                driver.findElement(btnRegister).click();
                Thread.sleep(10000);
                System.out.println(Hooks.Temp.userName);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void verifyRegistration() {
        try {
            BasePage.closeSurvey();
            Assert.assertTrue("User Registered Successfully", driver.findElement(HomePage.lnkLogout).isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
