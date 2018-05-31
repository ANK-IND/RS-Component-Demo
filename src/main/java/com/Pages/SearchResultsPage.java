package com.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {


    public static By txtResultCount = By.xpath("//div[@class='search-matches']//h1");
    public static By ddSortBy = By.xpath("//span[contains(text(),'Relevance')]");
    public static By ddSortOptions = By.xpath("//ul[@aria-labelledby='sortOrder']");
    public static By txtPrice = By.xpath("//span[@data-qa='price']");
    public static By btnGridView = By.xpath("//div[@title='Grid view']");
    public static By btnListView = By.xpath("//div[@title='List View']");
    public static By btnAdd = By.xpath("//button[@data-qa='add-to-basket-btn']");
    public static By btnTopCategories = By.xpath("//button[@data-qa='top-categories-expander']");


    public static void searchPageResults() {
        try {
            if (driver.findElement(txtResultCount).isDisplayed()) {
                String productCount = driver.findElement(txtResultCount).getText();
                Assert.assertTrue("Search Results", productCount.contains("products found for"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sortBy_filter(String value) {
        try {
            driver.findElement(btnTopCategories).click();
            WebElement dd = driver.findElement(ddSortBy);

            driver.findElement(ddSortBy).click();
            List<WebElement> options = driver.findElements(ddSortOptions);
            for (WebElement opt : options) {
                if (value.equals(opt.getText())) ;
                opt.click();
                Thread.sleep(10000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void verifySort() {
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewSelection(String selectView) {
        try {
            if (selectView.contains("Grid")) {
                driver.findElement(btnGridView).click();
                System.out.println("Grid View selected");
            } else if (selectView.contains("List")) {
                driver.findElement(btnListView).click();
                System.out.println("List View selected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addToBasket() {
        try {
            driver.findElement(btnTopCategories).click();
            List<WebElement> addtoBasket = driver.findElements(btnAdd);
            Integer pdtCount = addtoBasket.size();
            for (WebElement add : addtoBasket) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", add);
                //add.click();
                js.executeScript("arguments[0].scrollIntoView();", add);
                Thread.sleep(10000);
            }
            String basketQty = driver.findElement(HomePage.lnkBasketQuanity).getText();
            Integer qty = Integer.parseInt(basketQty);
            if (pdtCount == qty) {
                System.out.println("All product in the page added to cart");
            } else {
                System.out.println("Some product not added to the cart");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

