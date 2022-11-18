package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class CheckoutAsGuestUser extends TestBase {
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

        HomePage.openHomePage();
        SearchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.currentProduct)
                .contains(product));
    }

    @Test(priority = 2, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddProductToShippingCart() throws InterruptedException {
        ProductDetailsPage.addToCar();
        HomePage.openShoppingCart();
        Assert.assertTrue(ElementActions.getText(CheckoutPage.productName)
                .contains(product));
    }

    @Test(priority = 3, dependsOnMethods = "UserCanAddProductToShippingCart")
    public void UserCanChangeProductQuantityInShippingCart() {
        CheckoutPage.changeQuantity(Integer.parseInt(quantity));
    }

    @Test(priority = 5, dependsOnMethods = "UserCanChangeProductQuantityInShippingCart")
    public void UserCanCheckout() throws InterruptedException {
        CheckoutPage.checkoutAsGuestUser(fname, lname, email, country, city, address, zip, phone);
        Assert.assertTrue(ElementActions.getText(CheckoutPage.checkoutCompletedMessage).contains("Your order has been successfully processed!"));
    }
}