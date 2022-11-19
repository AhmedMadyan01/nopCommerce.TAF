package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class PrintOrderInformationTest extends TestBase {
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
        HomePage.openHomePage();
        HomePage.openRegistrationPage();
        UserRegistrationPage.userRegistration(fname, lname, email,
                password, password);
        Assert.assertTrue(ElementActions.getText(UserRegistrationPage.registrationCompletedMessage)
                .contains("Your registration completed"));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanRegister")
    public void UserCanSearchProduct() {
        HomePage.openHomePage();
        SearchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.currentProduct)
                .contains(product));
    }

    @Test(priority = 3, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToShippingCart() throws InterruptedException {
        ProductDetailsPage.addToCar();
        HomePage.openShoppingCart();
        Assert.assertTrue(ElementActions.getText(CheckoutPage.productName)
                .contains(product));
    }

    @Test(priority = 4, dependsOnMethods = "UserCanAddProductToShippingCart")
    public void UserCanChangeProductQuantityInShippingCart() {
        CheckoutPage.changeQuantity(quantity);
        Assert.assertTrue(ElementActions.getAttribute(CheckoutPage.quantity, "value")
                .contains(Integer.toString(quantity)));
    }

    @Test(priority = 5, dependsOnMethods = "UserCanChangeProductQuantityInShippingCart")
    public void UserCanCheckout() {
        CheckoutPage.checkoutAsRegisteredUser(fname, lname, email, country, city, address, zip, phone);
        Assert.assertTrue(ElementActions.getText(CheckoutPage.checkoutCompletedMessage).contains("Your order has been successfully processed!"));
    }

    @Test(priority = 6, dependsOnMethods = "UserCanCheckout")
    public void UserCanPrintOrderInfo() {
        CheckoutPage.openOrderInformationPage();
        OrderInformation.printOrder();
    }

    @Test(priority = 7, dependsOnMethods = "UserCanCheckout")
    public void UserCanLogout() {
        HomePage.userLogout();
    }
}