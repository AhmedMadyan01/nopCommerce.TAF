package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    private final String email = "testtests133@test.com";
    private final String newPassword = "FdJnx@SXP7uSaaspJ";

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() {
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
        userRegistrationPage = new UserRegistrationPage(driver);
        String fName = "test";
        String lName = "test";
        String password = "FdJnx@SXP7uSspJ";
        userRegistrationPage.userRegistration(fName, lName,
                email, password, password);
    }

    @Test(priority = 2, dependsOnMethods = "UserCanRegisterSuccessfully")
    public void userCanChanePassword() {
        myAccountPage = new MyAccountPage(driver);
        homePage.openMyAccountPage();
        String oldPassword = "FdJnx@SXP7uSspJ";
        myAccountPage.changePassword(oldPassword, newPassword);
    }

    @Test(priority = 3, dependsOnMethods = "userCanChanePassword")
    public void RegisteredUserCanLogout() {
        homePage = new HomePage(driver);
        homePage.userLogout();
    }

    @Test(priority = 4, dependsOnMethods = "RegisteredUserCanLogout")
    public void RegisteredUserCanLogin() {
        loginPage = new LoginPage(driver);
        homePage.openLoginPage();
        loginPage.login(email, newPassword);
    }
}
