package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class UserRegistrationPage extends PageBase {
    @FindBy(id = "gender-male")
    WebElement maleGenderRdoBtn;
    @FindBy(id = "FirstName")
    WebElement firstNameTxtBox;
    @FindBy(id = "LastName")
    WebElement lastNameTxtBox;
    @FindBy(id = "Email")
    WebElement emailTxtBox;
    @FindBy(id = "Password")
    WebElement passwordTxtBox;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox;
    @FindBy(id = "register-button")
    WebElement registerBtn;
    @FindBy(css = "div.result")
    public static WebElement registrationCompletedMessage;

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void userRegistration(String firstName, String lastName,
                                 String email, String password, String confirmPassword) {
        clickOnElement(maleGenderRdoBtn);
        setTxtElement(firstNameTxtBox, firstName);
        setTxtElement(lastNameTxtBox, lastName);
        setTxtElement(emailTxtBox, email);
        setTxtElement(passwordTxtBox, password);
        setTxtElement(confirmPasswordTxtBox, confirmPassword);
        clickOnElement(registerBtn);
    }
}
