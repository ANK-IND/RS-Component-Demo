package com.Pages;

import com.cucumber.listener.Reporter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public static By txtLoginUsername = By.name("username");
    public static By txtLoginPassword = By.name("j_password");
    public static By btnLogin = By.name("loginBtn");
    public static By txtCheckoutLoginUsername = By.id("loginForm:LoginWidgetAction_username_decorate:LoginWidgetAction_username");
    public static By txtCheckoutLoginPassword = By.id("loginForm:LoginWidgetAction_password_decorate:LoginWidgetAction_password");
    public static By btnCheckoutLogin = By.id("loginForm:login");
    public static By formLoginForm=By.id("loginForm");


    public static void clickLogin() {
        try {
            if (driver.findElement(HomePage.lnkLogin).isDisplayed()) {
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(HomePage.lnkLogin)));
                driver.findElement(HomePage.lnkLogin).click();
                Assert.assertTrue(driver.findElement(txtLoginUsername).isDisplayed());
                Reporter.addStepLog(" Login link clicked Successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void verifyLoginNav() {
        try {
            if (driver.findElement(txtLoginUsername).isDisplayed()) {
                Reporter.addStepLog(" User navigated to Login page Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void verifyLogin() {
        try {
            if (driver.findElement(HomePage.lnkLogout).isDisplayed()) {
                Reporter.addStepLog(" User Logged In Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void login(String userName, String password) {
        try {
            if (driver.findElement(txtLoginUsername).isDisplayed()) {
                driver.findElement(txtLoginUsername).sendKeys(userName);
                driver.findElement(txtLoginPassword).sendKeys(password);
                driver.findElement(btnLogin).click();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(HomePage.lnkLogout)));
                Assert.assertTrue(driver.findElement(HomePage.lnkLogout).isDisplayed());
                Reporter.addStepLog("User Logged In");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void CheckoutLogin(String userName, String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(formLoginForm)));
            if (driver.findElement(formLoginForm).isDisplayed()) {
                driver.findElement(txtCheckoutLoginUsername).sendKeys(userName);
                driver.findElement(txtCheckoutLoginPassword).sendKeys(password);
                driver.findElement(btnCheckoutLogin).click();
                Assert.assertTrue(driver.findElement(DeliveryAddressPage.btnContinue_Payment).isDisplayed());
                Reporter.addStepLog("User Login Successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
