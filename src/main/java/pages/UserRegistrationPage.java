package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.actions.ElementActions;

import java.util.concurrent.TimeUnit;

public class UserRegistrationPage {
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");

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


    public void userRegistration(String firstName, String lastName,
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
