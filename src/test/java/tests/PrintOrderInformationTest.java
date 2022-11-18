package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.test_base.TestBase;

public class PrintOrderInformationTest extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    UserRegistrationPage userRegistrationPage;
    CheckoutPage checkoutPage;
    OrderInformation orderInformation;
    String fname = "Ahmed";
    String lname = "Mahmoud";
    String password = "123456";
    String email = "user12@test.com";
    String country = "Egypt";
    String city = "Cairo";
    String address = "Cairo";
    String zip = "12345";
    String phone = "010000000";
    String product = "Apple MacBook Pro 13-inch";
    int quantity = 5;

    @Test(priority = 1)
    public void UserCanRegister() {
        homePage = new HomePage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
        HomePage.openHomePage();
        HomePage.openRegistrationPage();
        userRegistrationPage.userRegistration(fname, lname, email,
                password, password);
        Assert.assertTrue(UserRegistrationPage.registrationCompletedMessage
                .getText()
                .contains("Your registration completed"));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanRegister")
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

    @Test(priority = 3, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToShippingCart() throws InterruptedException {
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        ProductDetailsPage.addToCar();
        HomePage.openShoppingCart();
        Assert.assertTrue(CheckoutPage.productName
                .getText()
                .contains(product));
    }

    @Test(priority = 4, dependsOnMethods = "UserCanAddProductToShippingCart")
    public void UserCanChangeProductQuantityInShippingCart() {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        CheckoutPage.changeQuantity(quantity);
        Assert.assertTrue(CheckoutPage.quantity
                .getAttribute("value")
                .contains(Integer.toString(quantity)));
    }

    @Test(priority = 5, dependsOnMethods = "UserCanChangeProductQuantityInShippingCart")
    public void UserCanCheckout() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        CheckoutPage.checkoutAsRegisteredUser(fname, lname, email, country, city, address, zip, phone);
        Assert.assertTrue(CheckoutPage.checkoutCompletedMessage
                .getText().contains("Your order has been successfully processed!"));
    }

    @Test(priority = 6, dependsOnMethods = "UserCanCheckout")
    public void UserCanPrintOrderInfo() {
        orderInformation = new OrderInformation(driver);
        checkoutPage = new CheckoutPage(driver);
        CheckoutPage.openOrderInformationPage();
        OrderInformation.printOrder();
    }

    @Test(priority = 7, dependsOnMethods = "UserCanCheckout")
    public void UserCanLogout() {
        homePage = new HomePage(driver);
        HomePage.userLogout();
    }
}
