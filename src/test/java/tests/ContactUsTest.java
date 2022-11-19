package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class ContactUsTest extends TestBase {
    String name = "Ahmed";
    String email = "test@test.com";
    String enquiry = "Is Enquiry works good ?!";

    @Test
    public void UserCanSendEnquiry() {
        HomePage.openContactUsPage();
        ContactUsPage.sendEnquiry(name, email, enquiry);
        Assert.assertTrue(ElementActions.getText(ContactUsPage.enquiryConfirmationMessage).contains("Your enquiry has been successfully sent to the store owner."))
        ;
    }
}