package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class MyAccountPage extends PageBase {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;
    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxtBox;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxtBox;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(css = "input.button-1.change-password-button")
    WebElement changePasswordBtn;

    public void changePassword(String oldPassword, String newPassword) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        clickOnElement(changePasswordLink);
        setTxtElement(oldPasswordTxtBox, oldPassword);
        setTxtElement(newPasswordTxtBox, newPassword);
        setTxtElement(confirmPasswordTxtBox, newPassword);
        clickOnElement(changePasswordBtn);
    }

}

