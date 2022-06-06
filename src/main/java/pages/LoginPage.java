package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailTxtBox;

    @FindBy(id = "Password")
    WebElement passwordTxtBox;

    @FindBy(css = "input.button-1.login-button")
    WebElement loginBtn;

    public void login(String email, String password) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        setTxtElement(emailTxtBox, email);
        setTxtElement(passwordTxtBox, password);
        clickOnElement(loginBtn);
    }
}
