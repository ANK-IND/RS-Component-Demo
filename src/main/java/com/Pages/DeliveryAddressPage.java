package com.Pages;

import com.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class DeliveryAddressPage extends BasePage {


    public static By txtCompanyname = By.id("deliveryCollectionForm:AddLoggedInUserDeliveryAddressWidgetAction_companyNameOne_decorate:AddLoggedInUserDeliveryAddressWidgetAction_companyNameOne");
    public static By txtAddress1 = By.id("deliveryCollectionForm:AddLoggedInUserDeliveryAddressWidgetAction_addressLineOne_decorate:AddLoggedInUserDeliveryAddressWidgetAction_addressLineOne");
    public static By txtPostcode = By.id("deliveryCollectionForm:AddLoggedInUserDeliveryAddressWidgetAction_postCode_decorate:AddLoggedInUserDeliveryAddressWidgetAction_postCode");
    public static By txtTown = By.id("deliveryCollectionForm:AddLoggedInUserDeliveryAddressWidgetAction_addressLineThree_decorate:AddLoggedInUserDeliveryAddressWidgetAction_addressLineThree");
    public static By dd_County = By.id("deliveryCollectionForm:AddLoggedInUserDeliveryAddressWidgetAction_selectedRegion_decorate:selectedRegion");
    public static By btnContinue_Payment = By.xpath("//span[contains(text(),'Continue to payment')]");
    public static By btnContinue_OrderReview = By.xpath("//span[contains(text(),'Continue to order review')]");


    public static void enterDeliveryAddress(DataTable deliveryDetails) {
        try {

            if (driver.findElement(DeliveryAddressPage.btnContinue_Payment).isDisplayed()) {
                Reporter.addStepLog("Already using Previous address");
            } else {
                for (Map<String, String> address : deliveryDetails.asMaps(String.class, String.class)) {

                    driver.findElement(txtCompanyname).sendKeys(address.get("Company"));
                    driver.findElement(txtAddress1).sendKeys(address.get("Address1"));
                    driver.findElement(txtTown).sendKeys(address.get("Town"));
                    WebElement county = driver.findElement(dd_County);
                    //Dropdown to Select County
                    BasePage.drop_Down(county, address.get("County"));
                    driver.findElement(txtPostcode).sendKeys(address.get("Postcode"));
                }
                Reporter.addStepLog("Delivery Details added successfully");
            }
            driver.findElement(btnContinue_Payment).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void VerifyDelivery_Nav() {
        try {
            if (driver.findElement(btnContinue_Payment).isDisplayed()) {
                Reporter.addStepLog("User navigated to Delivery Page Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void VerifyPayment_Nav() {
        try {
            if (driver.findElement(btnContinue_OrderReview).isDisplayed()) {
                Reporter.addStepLog("User navigated to Payment Page Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}