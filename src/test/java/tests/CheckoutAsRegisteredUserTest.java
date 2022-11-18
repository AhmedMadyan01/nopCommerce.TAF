package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutAsRegisteredUserTest extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    UserRegistrationPage userRegistrationPage;
    CheckoutPage checkoutPage;
    OrderInformation orderInformation;
    String fname = "Ahmed";
    String lname = "Mahmoud";
    String password = "123456";
    String email = "user1@test.com";
    String message = "Check this product";
    String country = "Egypt";
    String city = "Cairo";
    String address = "Cairo";
    String zip = "12345";
    String phone = "010000000";

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
    public void UserCanCheckout() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkoutAsRegisteredUser(fname, lname, email, country, city, address, zip, phone);
        Assert.assertTrue(checkoutPage.checkoutCompletedMessage
                .getText().contains("Your order has been successfully processed!"));
    }

    @Test(priority = 6, dependsOnMethods = "UserCanCheckout")
    public void UserCanDownloadPDFInvoice() {
        orderInformation = new OrderInformation(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.openOrderInformationPage();
        orderInformation.downloadPDFInvoice();
    }

    @Test(priority = 7, dependsOnMethods = "UserCanCheckout")
    public void UserCanPrintOrderInfo() {
        orderInformation = new OrderInformation(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.openOrderInformationPage();
        orderInformation.printOrder();
    }

    @Test(priority = 8, dependsOnMethods = "UserCanCheckout")
    public void UserCanLogout() {
        homePage = new HomePage(driver);
        homePage.userLogout();
    }

}
