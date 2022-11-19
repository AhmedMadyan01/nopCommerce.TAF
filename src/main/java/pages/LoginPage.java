package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class LoginPage {
    public static final By emailTxtBox = By.id("Email");
    public static final By passwordTxtBox = By.id("Password");
    public static final By loginBtn = By.cssSelector("input.button-1.login-button");

    public static void login(String email, String password) {
        ElementActions.sendKeys(emailTxtBox, email);
        ElementActions.sendKeys(passwordTxtBox, password);
        ElementActions.click(loginBtn);
    }
}