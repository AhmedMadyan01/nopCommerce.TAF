package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class ChangeCurrencyTest extends TestBase {
    HomePage homePage;
    String currency = "euro";
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    String product = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void UserCanSearchProductUsingAutoSuggest() {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(productDetailsPage.currentProduct.getText().contains(product));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanSearchProductUsingAutoSuggest")
    public void UserCanChangeCurrency() {
        homePage = new HomePage(driver);
        homePage.changeCurrency(currency);
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.productPriceValue).contains("Ђ"));
        System.out.println(product + "  " + ElementActions.getText(ProductDetailsPage.productPriceValue));
    }
}