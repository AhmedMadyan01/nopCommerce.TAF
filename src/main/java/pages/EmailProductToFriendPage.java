package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailProductToFriendPage extends PageBase {
    public EmailProductToFriendPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(id = "FriendEmail")
    WebElement friendEmailTxtBox;

    @FindBy(id = "YourEmailAddress")
    WebElement userEmail;

    @FindBy(id = "PersonalMessage")
    WebElement personalMessageTxtBox;

    @FindBy(css = "input.button-1.send-email-a-friend-button")
    WebElement sendEmailBtn;



    public void emailProductToFriend(String fEmail, String email, String message) {
        setTxtElement(friendEmailTxtBox, fEmail);
        setTxtElement(userEmail, email);
        setTxtElement(personalMessageTxtBox, message);
        clickOnElement(sendEmailBtn);
    }
}
