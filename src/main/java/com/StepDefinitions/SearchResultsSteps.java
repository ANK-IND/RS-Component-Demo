package com.StepDefinitions;

import com.Pages.SearchResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SearchResultsSteps {



    @Then("^Verify SearchResultPage is displayed with correct product Keyword$")
    public static void verifySearchResults(){
        SearchResultsPage.searchPageResults();

    }

    @And("^User selects sort by (.*) for SearchResults$")
    public static void sortBy(String value){
        SearchResultsPage.sortBy_filter(value);
    }

    @And("^User selects (.*)for Search results")
    public static void selectView(String view){
        SearchResultsPage.viewSelection(view);
    }

    @Then("^Verify SearchResultPage is sorted as Price: Low to High option$")
    public static void verifySorting(){
        SearchResultsPage.verifySort();
    }

    @Then("^Add all the product in the page$")
    public static void addProduct(){
        SearchResultsPage.addToBasket();
    }
}
