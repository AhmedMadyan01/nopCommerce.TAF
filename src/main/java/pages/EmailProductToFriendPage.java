package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class EmailProductToFriendPage {
    public static final By friendEmailTxtBox = By.id("FriendEmail");
    public static final By userEmail = By.id("YourEmailAddress");
    public static final By personalMessageTxtBox = By.id("PersonalMessage");
    public static final By sendEmailBtn = By.cssSelector("input.button-1.send-email-a-friend-button");

    public static void emailProductToFriend(String fEmail, String email, String message) {
        ElementActions.sendKeys(friendEmailTxtBox, fEmail);
        ElementActions.sendKeys(userEmail, email);
        ElementActions.sendKeys(personalMessageTxtBox, message);
        ElementActions.click(sendEmailBtn);
    }
}