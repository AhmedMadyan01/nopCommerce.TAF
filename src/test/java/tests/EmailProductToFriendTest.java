package tests;

import org.testng.annotations.Test;
import pages.*;
import utilities.test_base.TestBase;

public class EmailProductToFriendTest extends TestBase {
    String fname = "Ahmed";
    String lname = "Mahmoud";
    String password = "123456";
    String fMail = "friend@test.com";
    String email = "user01ds5g1@test.com";
    String message = "Check this product";
    String product = "Apple MacBook Pro 13-inch";

    @Test
    public void UserCanEmailProductToFriend() {
        HomePage.openRegistrationPage();
        UserRegistrationPage.userRegistration(fname, lname, email, password, password);
        HomePage.openHomePage();
        SearchPage.searchProductByAutoSuggest(product);
        ProductDetailsPage.openEmailFriendPage();
        EmailProductToFriendPage.emailProductToFriend(fMail, email, message);
    }
}