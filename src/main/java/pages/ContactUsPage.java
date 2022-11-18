package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class ContactUsPage {
    public static final By yourNameTxtBox = By.id("FullName");
    public static final By emailTxtBox = By.id("Email");
    public static final By enquiryTxtBox = By.id("Enquiry");
    public static final By submitEnquiryBtn = By.cssSelector("input.button-1.contact-us-button");
    public static final By enquiryConfirmationMessage = By.cssSelector("div.result");

    public void sendEnquiry(String name, String email, String enquiry) {
        ElementActions.sendKeys(yourNameTxtBox, name);
        ElementActions.sendKeys(emailTxtBox, email);
        ElementActions.sendKeys(enquiryTxtBox, enquiry);
        ElementActions.click(submitEnquiryBtn);
    }

}
