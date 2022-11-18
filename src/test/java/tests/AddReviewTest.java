package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class AddReviewTest extends TestBase {
    /*
     * 1- User Registration
     * 2- Search product
     * 3- Add Review
     * 4- Logout
     * */
    // Required Data for Registration Test
    String fName = "Ahmed";
    String lName = "Madyan";
    String email = "test211111@test.com";
    String password = "FdJnx@SXP7uSspJ";
    // Required Data for Search Test
    String product = "Apple MacBook Pro 13-inch";
    // Required Data for Review Test
    String title = "Apple MacBook Pro 13-inch";
    String text = "Product is good enough";
    String rate = "2";

    /*1- User Registration */
    @Test(priority = 1)
    public void UserCanRegister() {
        HomePage.openRegistrationPage();
        UserRegistrationPage.userRegistration(fName, lName, email, password, password);
        Assert.assertTrue(ElementActions.getText(UserRegistrationPage.registrationCompletedMessage).contains("Your registration completed"));
    }

    /*2- Search product */
    @Test(priority = 2, dependsOnMethods = "UserCanRegister")
    public void UserCanSearchProduct() {
        HomePage.openHomePage();
        SearchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.currentProduct).contains(product));
    }

    /*3- Add review */
    @Test(priority = 3, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddReview() {
        ProductDetailsPage.openAddReviewPage();
        ProductReviewPage.reviewProduct(title, text, rate);
        Assert.assertTrue(ElementActions.getText(ProductReviewPage.reviewAddedMessage)
                .contains("Product review is successfully added."));
    }

    /*4- Logout */
    @Test(priority = 4, dependsOnMethods = "UserCanAddReview")
    public void UserCanLogout() {
        HomePage.userLogout();
    }
}