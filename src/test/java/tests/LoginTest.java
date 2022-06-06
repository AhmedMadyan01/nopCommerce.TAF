package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void userCanLoginSuccessfully() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.openLoginPage();
        loginPage.login("test33@test.com", "FdJnx@SXP7uSspJ");
    }
}