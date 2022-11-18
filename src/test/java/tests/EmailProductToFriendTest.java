package tests;

import org.testng.annotations.Test;
import pages.*;
import utilities.test_base.TestBase;

public class EmailProductToFriendTest extends TestBase {
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    EmailProductToFriendPage emailProductToFriendPage;
    String fname = "Ahmed";
    String lname = "Mahmoud";
    String password = "123456";
    String fMail = "friend@test.com";
    String email = "user01ds5g1@test.com";
    String message = "Check this product";
    String product = "Apple MacBook Pro 13-inch";

    @Test
    public void UserCanEmailProductToFriend() throws InterruptedException {
        homePage = new HomePage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        emailProductToFriendPage = new EmailProductToFriendPage(driver);
        homePage.openRegistrationPage();
        userRegistrationPage.userRegistration(fname,lname,email,password,password);
        homePage.openHomePage();
        searchPage.searchProductByAutoSuggest(product);
        productDetailsPage.openEmailFriendPage();
        emailProductToFriendPage.emailProductToFriend(fMail, email, message);
        
    }
}
