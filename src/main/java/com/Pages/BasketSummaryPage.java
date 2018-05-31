package com.Pages;

import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketSummaryPage extends BasePage {

    public static By hdgMyBasket = By.xpath("//div[@class='pageTitleBlack']");
    public static By btnCheckoutSecurely = By.id("checkoutSecurelyAndPuchBtn");
    public static By tabDelivery = (By.xpath("//*[@id='deliveryAndCollectionSelector']/div[1]/button"));
    public static By tabBranchCollection = (By.id("js-branchCollectionBtn"));
    public static By ddBranch = By.id("shoppingBasketForm:tradecounterDropDown");
    public static By delvOption1 = By.xpath("(//input[@type='radio'])[1]");


    public static void basketQty() {
        try {
            BasePage.closeSurvey();
            System.out.print(driver.getTitle());
            if (driver.findElement(hdgMyBasket).isDisplayed()) {
                Reporter.addStepLog("User in Basket Summary");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deliveryOption(String delivery) {
        try {
            if (delivery.contains("Delivery")) {
                if (driver.findElement(tabDelivery).isDisplayed()) {
                    driver.findElement(tabDelivery).click();
                    driver.findElement(delvOption1).isSelected();
                    Reporter.addStepLog("Next Working day Delivery ");
                }
            } else if (delivery.contains("Branch")) {
                if (driver.findElement(tabBranchCollection).isDisplayed()) {
                    driver.findElement(tabBranchCollection).click();
                    WebElement select_branch = driver.findElement(ddBranch);
                    BasePage.drop_Down(select_branch, "7554184");
                    Reporter.addStepLog("Birmingham Trade Counter selected for Branch Collection");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void checkout_Basket() {
        try {
            BasePage.closeSurvey();
            JavascriptExecutor js= (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(btnCheckoutSecurely));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnCheckoutSecurely)));
            driver.findElement(btnCheckoutSecurely).click();

            Reporter.addStepLog("Basket Checkout successfully completed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
