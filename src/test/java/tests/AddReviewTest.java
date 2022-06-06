package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddReviewTest extends TestBase {
    /*
     * 1- User Registration
     * 2- Search product
     * 3- Add Review
     * 4- Logout
     * */
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ProductReviewPage productReviewPage;
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
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.userRegistration(fName, lName, email, password, password);
        Assert.assertTrue(userRegistrationPage.registrationCompletedMessage
                .getText().contains("Your registration completed"));
    }
    /*2- Search product */
    @Test(priority = 2, dependsOnMethods = "UserCanRegister")
    public void UserCanSearchProduct() {
        productDetailsPage = new ProductDetailsPage(driver);
        homePage.openHomePage();
        searchPage = new SearchPage(driver);
        searchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(productDetailsPage.currentProduct.getText().contains(product));
    }
    /*3- Add review */
    @Test(priority = 3, dependsOnMethods = "UserCanSearchProduct")
    public void UserCanAddReview() {
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.openAddReviewPage();
        productReviewPage = new ProductReviewPage(driver);
        productReviewPage.reviewProduct(title, text, rate);
        Assert.assertTrue(productReviewPage.reviewAddedMessage.getText()
                .contains("Product review is successfully added."));
    }
    /*4- Logout */
    @Test(priority = 4, dependsOnMethods = "UserCanAddReview")
    public void UserCanLogout() {
        homePage = new HomePage(driver);
        homePage.userLogout();
    }

}
