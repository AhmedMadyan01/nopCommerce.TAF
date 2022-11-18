package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class AddToWishlistTest extends TestBase {
    String product = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void UserCanSearchProduct() {
        HomePage.openHomePage();
        SearchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.currentProduct).contains(product));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToWishList() {
        ProductDetailsPage.addToWishList();
    }

    @Test(priority = 3, dependsOnMethods = "UserCanAddProductToWishList")
    public void UserCanRemoveProductFromCart() {
        HomePage.openWishlistPage();
        WishlistPage.removeFromCart();
    }
}