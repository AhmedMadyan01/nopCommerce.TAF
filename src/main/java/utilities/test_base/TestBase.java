package utilities.test_base;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import utilities.driver_manager.DriverManager;

import java.io.IOException;

public abstract class TestBase {

    @BeforeSuite
    @Parameters({"browser"})
    public static void setDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            DriverManager.launchChrome();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            DriverManager.launchFirefox();
        }
        DriverManager.navigate("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void takesScreenshots(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenshot(DriverManager.getDriver(), result.getName() + "-Failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Helper.captureScreenshot(DriverManager.getDriver(), result.getName() + "-Passed");
        }
    }

    @AfterSuite
    public void tearDownDriver() {
        DriverManager.quit();
    }
}
