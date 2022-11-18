package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;
import utilities.test_base.TestBase;

public class AddToWishlistTest extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    WishlistPage wishlistPage;
    String product = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void UserCanSearchProduct() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        homePage.openHomePage();
        searchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(productDetailsPage.currentProduct.getText().contains(product));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToWishList() throws InterruptedException {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        wishlistPage = new WishlistPage(driver);
        productDetailsPage.addToWishList();
        Thread.sleep(2000);
    }

    @Test(priority = 3, dependsOnMethods = "UserCanAddProductToWishList")
    public void UserCanRemoveProductFromCart() {
        homePage = new HomePage(driver);
        wishlistPage = new WishlistPage(driver);
        homePage.openWishlistPage();
        wishlistPage.removeFromCart();
    }
}
