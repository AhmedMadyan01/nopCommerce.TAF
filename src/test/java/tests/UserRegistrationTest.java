package tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
    HomePage homePage;
    UserRegistrationPage userRegistrationPage;
    LoginPage loginPage;

    @DataProvider(name = "userRegistrationData")
    public static Object[][] userRegistrationData() {
        return new Object[][]
                {{"Ahmed", "Mahmoud", "test@test.com", "FdJnx@SXP7uSspJ"},
                        {"Mohamed", "Ahmed", "test1@test.com", "FdJnx@SXP7uSspJ"}};
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "userRegistrationData")
    public void UserCanRegisterSuccessfully(String firstName, String lastName, String email, String password) {
        homePage = new HomePage(driver);
        userRegistrationPage = new UserRegistrationPage(driver);
        loginPage = new LoginPage(driver);
        /*
         * 1- User Registration
         * */
        homePage.openRegistrationPage();
        userRegistrationPage.userRegistration(firstName, lastName,
                email, password, password);
        /*
         * 2- User logout
         * */
        homePage.userLogout();
        /*
         * 3- login with the registered user
         * */
        homePage.openLoginPage();
        loginPage.login(email, password);
        /*
         * 4- User logout
         * */
        homePage.userLogout();
    }
}
