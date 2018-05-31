package com.Pages;

import com.StepDefinitions.Hooks;
import com.cucumber.listener.Reporter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage {


    public static By txtQty = By.xpath("//div[@class='input-group spinner']//input[@type='text']");
    public static By iconGetBasketQty = By.id("js-basketQty");
    public static By btnAddtoBasket = By.xpath("//button[contains(text(),'Add to basket')]");
    public static By txtAdded = By.xpath("//span[contains(text(),'Added')]");
    public static By btnViewBasket = By.xpath("//button[@type='button'][contains(text(),'View Basket')]");
    public static By txtProduct_no = By.xpath("//span[@class='keyValue bold']");
    public static By lnkStock = By.cssSelector("a.check-stock-level-link");
    public static By modal_CheckStock = By.xpath("//div[@class='modal-dialog']");
    public static By btnModal_Checkout = By.xpath("//button[contains(text(),'Checkout')]");
    public static By btnModal_Continue = By.xpath("//button[contains(text(),'Continue Shopping')]");
    public static By txtModal_Quantity = By.cssSelector("input.check-quantity");
    public static By modal_btnCheckstock = By.xpath("//button[contains(text(),'Check')]");
    public static By modal_txtStockConf = By.cssSelector(".atp-text");
    public static By modal_btnAdd = By.xpath("//button[@class='btn btn-primary-red btn-add-to-basket']");

    public static void verifyProductNavigation() {
        try {
            if (driver.findElement(txtProduct_no).isDisplayed()) {
                String product_no = driver.findElement(txtProduct_no).getText();
                Assert.assertTrue(product_no.equals(Hooks.Temp.rsStockNO));
                Reporter.addStepLog("User Navigated to Product Detail page");
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void verifyStocklevel(String quantity) {
        try {

            WebElement stock = driver.findElement(lnkStock);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", stock);
            if (driver.findElement(lnkStock).isDisplayed()) {
                js.executeScript("arguments[0].click();", driver.findElement(lnkStock));
                //driver.findElement(lnkStock).click();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(modal_CheckStock)));
                if (driver.findElement(modal_CheckStock).isDisplayed()) {
                    driver.findElement(txtModal_Quantity).clear();
                    driver.findElement(txtModal_Quantity).sendKeys(quantity);
                    driver.findElement(modal_btnCheckstock).click();
                    String ss = driver.findElement(modal_txtStockConf).getText();
                    driver.findElement(modal_btnAdd).click();
                    Reporter.addStepLog(quantity + " quantity added in the cart ");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void addtoBasket(String quantity) {
        try {
            if (driver.findElement(txtQty).isDisplayed()) {
                driver.findElement(txtQty).clear();
                driver.findElement(txtQty).sendKeys(quantity);
                driver.findElement(btnAddtoBasket).click();
                //Assert.assertTrue((driver.findElement(iconGetBasketQty).getText()).equals(quantity));
                Reporter.addStepLog("5 Quantity added to Basket");
                driver.findElement(btnViewBasket).click();
                BasePage.closeSurvey();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public static void modal_Checkout(String checkout) {
        try {
            BasePage.closeSurvey();
            if (driver.findElement(btnModal_Checkout).isDisplayed()) {
                driver.findElement(btnModal_Checkout).click();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}