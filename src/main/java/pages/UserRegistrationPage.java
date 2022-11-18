package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class UserRegistrationPage {
    private static final By maleGenderRdoBtn = By.id("gender-male");
    private static final By firstNameTxtBox = By.id("FirstName");
    private static final By lastNameTxtBox = By.id("LastName");
    private static final By emailTxtBox = By.id("Email");
    private static final By passwordTxtBox = By.id("Password");
    private static final By confirmPasswordTxtBox = By.id("ConfirmPassword");
    private static final By registerBtn = By.id("register-button");
    public static final By registrationCompletedMessage = By.cssSelector("div.result");

    public static void userRegistration(String firstName, String lastName,
                                        String email, String password, String confirmPassword) {
        ElementActions.click(maleGenderRdoBtn);
        ElementActions.sendKeys(firstNameTxtBox, firstName);
        ElementActions.sendKeys(lastNameTxtBox, lastName);
        ElementActions.sendKeys(emailTxtBox, email);
        ElementActions.sendKeys(passwordTxtBox, password);
        ElementActions.sendKeys(confirmPasswordTxtBox, confirmPassword);
        ElementActions.click(registerBtn);
    }
}