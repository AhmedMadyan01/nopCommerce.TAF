package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class MyAccountPage {
    public static final By changePasswordLink = By.linkText("Change password");
    public static final By oldPasswordTxtBox = By.id("OldPassword");
    public static final By newPasswordTxtBox = By.id("NewPassword");
    public static final By confirmPasswordTxtBox = By.id("ConfirmNewPassword");
    public static final By changePasswordBtn = By.cssSelector("input.button-1.change-password-button");

    public static void changePassword(String oldPassword, String newPassword) {
        ElementActions.click(changePasswordLink);
        ElementActions.sendKeys(oldPasswordTxtBox, oldPassword);
        ElementActions.sendKeys(newPasswordTxtBox, newPassword);
        ElementActions.sendKeys(confirmPasswordTxtBox, newPassword);
        ElementActions.click(changePasswordBtn);
    }
}