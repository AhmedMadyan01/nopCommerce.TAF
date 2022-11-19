package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.test_base.TestBase;

public class LoginTest extends TestBase {
    @Test
    public void userCanLoginSuccessfully() {
        HomePage.openLoginPage();
        LoginPage.login("test33@test.com", "FdJnx@SXP7uSspJ");
    }
}