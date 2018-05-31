package com.StepDefinitions;

import com.Pages.BasePage;
import com.Pages.HomePage;
import com.Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {


    @When("^User clicks on Login link$")
    public static void clickLogin(){
        LoginPage.clickLogin();

    }
    @Then("^Verify user is navigated to Login Page$")
    public static void verifyLoginNav(){
        LoginPage.verifyLoginNav();

    }
    @And("^User enter Login details (.*) and (.*) from Checkout$")
    public static void loginCheckout(String userName,String password){
        LoginPage.CheckoutLogin(userName,password);
    }

    @And("^User enter (.*) and (.*) for Login$")
    public static void loginDetails(String userName,String password){
        LoginPage.login(userName,password);

    }
    @Then("^Verify user is Logged In successfully$")
    public static void loginCheck(){
        LoginPage.verifyLogin();
    }


    @Given("^User is on RS Component HomePage$")
    public static void homePage() {
        BasePage.launchHomepage();
    }

    @Given("^User searches (.*) on the Search bar$")
    public static void searchProduct(String productName) {
        HomePage.searchProduct(productName);
    }
}
