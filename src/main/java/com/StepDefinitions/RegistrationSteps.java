package com.StepDefinitions;

import com.Pages.RegistrationPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {

    @When("^User clicks on Register links for Registration$")
    public void registration() {
        RegistrationPage.clickRegistration();
    }

    @Then("^Verify user navigation to Registration page$")
    public void
    navigateToRegistration() {
        RegistrationPage.verifyPageNavigation();

    }

    @And("^User enter details for Registration$")
    public void enterRegistrationDetails(DataTable userDetails) {
        RegistrationPage.enterUserDetails(userDetails);
    }

    @Then("^Verify user is successfully registered$")
    public void verifyUserRegistration() {
        RegistrationPage.verifyRegistration();
    }
}
