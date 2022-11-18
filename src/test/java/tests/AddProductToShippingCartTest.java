package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.test_base.TestBase;

public class AddProductToShippingCartTest extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    UserRegistrationPage userRegistrationPage;
    CheckoutPage checkoutPage;
    String fname = "Ahmed";
    String lname = "Mahmoud";
    String password = "123456";
    String email = "user3@test.com";
    String product = "Apple MacBook Pro 13-inch";
    String quantity = "5";

    @Test(priority = 1)
    public void UserCanRegister() {
        homePage = new HomePage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
        homePage.openHomePage();
        homePage.openRegistrationPage();
        userRegistrationPage.userRegistration(fname, lname, email,
                password, password);
        Assert.assertTrue(userRegistrationPage.registrationCompletedMessage
                .getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanRegister")
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

    @Test(priority = 3, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToShippingCart() throws InterruptedException {
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        productDetailsPage.addToCar();
        homePage.openShoppingCart();
        Assert.assertTrue(checkoutPage.productName
                .getText()
                .contains(product));
    }

    @Test(priority = 4, dependsOnMethods = "UserCanAddProductToShippingCart")
    public void UserCanChangeProductQuantityInShippingCart() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.changeQuantity(Integer.parseInt(quantity));
    }

    @Test(priority = 5, dependsOnMethods = "UserCanChangeProductQuantityInShippingCart")
    public void UserCanRemoveProductFromShippingCart() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.removeFormCart();
        Assert.assertTrue(CheckoutPage.emptyCartCheck
                .getText()
                .contains("Your Shopping Cart is empty!"));
    }
}
