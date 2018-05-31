package com.StepDefinitions;

import com.Pages.ProductDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ProductDetailSteps {

    @Then("^Verify user is navigated to Product Detail Page$")
    public static void verifyProductPageNavigation(){
        ProductDetailsPage.verifyProductNavigation();


    }

    @And("^User check Stock level and adds (.*) quantity to the cart for (.*)")
    public static void verifyStock(String quantity,String checkout){
        System.out.println(quantity);
        ProductDetailsPage.verifyStocklevel(quantity);
        ProductDetailsPage.modal_Checkout(checkout);

    }


    @And("^User adds (.*) quantity to Basket$")
    public static void addToCart(String quantity){
        ProductDetailsPage.addtoBasket(quantity);
    }
}
