package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.test_base.TestBase;

public class CheckoutAsGuestUser extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    UserRegistrationPage userRegistrationPage;
    CheckoutPage checkoutPage;
    String fname = "Ahmed";
    String lname = "Mahmoud";
    String email = "user5@test.com";
    String country = "Egypt";
    String city = "Cairo";
    String address = "Cairo";
    String zip = "12345";
    String phone = "010000000";

    String product = "Apple MacBook Pro 13-inch";
    String quantity = "5";


    @Test(priority = 1)
    public void UserCanSearchProduct() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        HomePage.openHomePage();
        SearchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(ProductDetailsPage.currentProduct
                .getText()
                .contains(product));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToShippingCart() throws InterruptedException {
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        ProductDetailsPage.addToCar();
        HomePage.openShoppingCart();
        Assert.assertTrue(CheckoutPage.productName
                .getText()
                .contains(product));
    }

    @Test(priority = 3, dependsOnMethods = "UserCanAddProductToShippingCart")
    public void UserCanChangeProductQuantityInShippingCart() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        CheckoutPage.changeQuantity(Integer.parseInt(quantity));
    }
    @Test(priority = 5, dependsOnMethods = "UserCanChangeProductQuantityInShippingCart")
    public void UserCanCheckout() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutAsGuestUser(fname, lname, email,country,city,address,zip,phone);
        Assert.assertTrue(CheckoutPage.checkoutCompletedMessage
                .getText().contains("Your order has been successfully processed!"));
    }

}
