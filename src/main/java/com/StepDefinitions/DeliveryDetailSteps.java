package com.StepDefinitions;

import com.Pages.DeliveryAddressPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class DeliveryDetailSteps {

    @Then("^Verify user is navigated to Delivery Details page$")
    public static void verifyDeliveryPageNav(){
        DeliveryAddressPage.VerifyDelivery_Nav();
    }

    @And("^User enters Delivery Details and Proceed for Payment$")
    public static void enterDeliveryAdd(DataTable deliveryDetails){
        DeliveryAddressPage.enterDeliveryAddress(deliveryDetails);
    }

    @Then("^Verify user is navigated to Payment page$")
        public static void verifyPaymentPageNav(){
        DeliveryAddressPage.VerifyPayment_Nav();
    }
}