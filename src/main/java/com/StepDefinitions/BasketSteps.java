package com.StepDefinitions;

import com.Pages.BasketSummaryPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class BasketSteps {


    @Then("^Verify Basket and Select (.*)$")
    public static void BasketSummary(String deliveryOptions){
        BasketSummaryPage.basketQty();
        BasketSummaryPage.deliveryOption(deliveryOptions);
    }

    @And("^Select Checkout Securely for Delivery Details page$")
    public static void checkoutSecurely(){
        BasketSummaryPage.checkout_Basket();

    }



}
