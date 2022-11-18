package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class ChangeCurrencyTest extends TestBase {
    String currency = "euro";
    String product = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void UserCanSearchProductUsingAutoSuggest() {
        SearchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.currentProduct).contains(product));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanSearchProductUsingAutoSuggest")
    public void UserCanChangeCurrency() {
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.productPriceValue).contains("Ђ"));
        System.out.println(product + "  " + ElementActions.getText(ProductDetailsPage.productPriceValue));
    }
}