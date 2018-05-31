package com.Pages;

import com.StepDefinitions.Hooks;
import org.openqa.selenium.By;

public class HomePage extends BasePage{



    public static By bnrCookies = By.className("cookie-consent");
    public static By btnAcceptCoookies = By.id("js-cookie-accept");
    public static By lnkLogin = By.xpath("//a[@title='Log In']");
    public static By lnkRegister = By.xpath("//a[contains(text(),'Register')]");
    public static By txtSearchBar = By.id("searchTerm");
    public static By btnSearch = By.id("btnSearch");
    public static By lnkBasketAmount = By.id("js-basketAmt");
    public static By lnkBasketQuanity = By.id("js-basketQty");
    public static By txtRSStockNO_1 = By.xpath("(//*[@name='stocknum'])[1]");
    public static By txtRSStockNO_2 = By.xpath("(//*[@name='stocknum'])[2]");
    public static By txtqty_1 = By.xpath("(//*[@name='qty'])[1]");
    public static By txtqty_2 = By.xpath("(//*[@name='qty'])[1]");
    public static By btnAddtoBasket = By.id("quickOrderBtn");
    public static By lnkLogout=By.xpath("//a[@href='https://uk.rs-online.com/web/logout.html']");



    public static void searchProduct(String productKeyword){

        try{
            BasePage.closeSurvey();
            Hooks.Temp.setRsStockNO(productKeyword);
            if(driver.findElement(HomePage.txtSearchBar).isDisplayed()){
                driver.findElement(HomePage.txtSearchBar).sendKeys(productKeyword);
                driver.findElement(HomePage.btnSearch).click();
            }
        }catch (Exception e){
            e.printStackTrace();
        }






    }

}
