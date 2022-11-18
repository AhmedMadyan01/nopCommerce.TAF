package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutAsGuestUser extends TestBase{
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
        homePage.openHomePage();
        searchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(productDetailsPage.currentProduct
                .getText()
                .contains(product));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToShippingCart() throws InterruptedException {
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productDetailsPage.addToCar();
        homePage.openShoppingCart();
        Assert.assertTrue(checkoutPage.productName
                .getText()
                .contains(product));
    }

    @Test(priority = 3, dependsOnMethods = "UserCanAddProductToShippingCart")
    public void UserCanChangeProductQuantityInShippingCart() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.changeQuantity(Integer.parseInt(quantity));
    }
    @Test(priority = 5, dependsOnMethods = "UserCanChangeProductQuantityInShippingCart")
    public void UserCanCheckout() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutAsGuestUser(fname, lname, email,country,city,address,zip,phone);
        Assert.assertTrue(checkoutPage.checkoutCompletedMessage
                .getText().contains("Your order has been successfully processed!"));
    }

}
