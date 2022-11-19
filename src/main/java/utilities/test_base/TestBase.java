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
        switch (browserName) {
            case "chrome" -> DriverManager.launchChrome();
            case "firefox" -> DriverManager.launchFirefox();
            case "edge" -> DriverManager.launchEdge();
            default -> throw new IllegalStateException("Unexpected value: " + browserName);
        }
//        DriverManager.navigate(System.getProperty("nopCommerce_URL"));
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