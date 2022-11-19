package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;
import utilities.test_base.TestBase;

public class MyAccountTest extends TestBase {
    private final String email = "testtests133@test.com";
    private final String newPassword = "FdJnx@SXP7uSaaspJ";

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() {
        HomePage.openRegistrationPage();
        String fName = "test";
        String lName = "test";
        String password = "FdJnx@SXP7uSspJ";
        UserRegistrationPage.userRegistration(fName, lName,
                email, password, password);
    }

    @Test(priority = 2, dependsOnMethods = "UserCanRegisterSuccessfully")
    public void userCanChanePassword() {
        HomePage.openMyAccountPage();
        String oldPassword = "FdJnx@SXP7uSspJ";
        MyAccountPage.changePassword(oldPassword, newPassword);
    }

    @Test(priority = 3, dependsOnMethods = "userCanChanePassword")
    public void RegisteredUserCanLogout() {
        HomePage.userLogout();
    }

    @Test(priority = 4, dependsOnMethods = "RegisteredUserCanLogout")
    public void RegisteredUserCanLogin() {
        HomePage.openLoginPage();
        LoginPage.login(email, newPassword);
    }
}