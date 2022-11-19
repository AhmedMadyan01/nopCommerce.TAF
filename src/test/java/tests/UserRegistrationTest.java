package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.test_base.TestBase;

public class UserRegistrationTest extends TestBase {
    @DataProvider(name = "userRegistrationData")
    public static Object[][] userRegistrationData() {
        return new Object[][]
                {{"Ahmed", "Mahmoud", "test@test.com", "FdJnx@SXP7uSspJ"},
                        {"Mohamed", "Ahmed", "test1@test.com", "FdJnx@SXP7uSspJ"}};
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "userRegistrationData")
    public void UserCanRegisterSuccessfully(String firstName, String lastName, String email, String password) {
        /*
         * 1- User Registration
         * */
        HomePage.openRegistrationPage();
        UserRegistrationPage.userRegistration(firstName, lastName,
                email, password, password);
        /*
         * 2- User logout
         * */
        HomePage.userLogout();
        /*
         * 3- login with the registered user
         * */
        HomePage.openLoginPage();
        LoginPage.login(email, password);
        /*
         * 4- User logout
         * */
        HomePage.userLogout();
    }
}