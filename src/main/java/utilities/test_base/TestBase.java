package utilities.test_base;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;
import utilities.properties_reader.ConfigUtils;
import utilities.properties_reader.PropertiesDataManager;

import java.io.IOException;

public abstract class TestBase {

    @BeforeSuite
    @Parameters({"browser"})
    public void setDriver(@Optional("chrome") String browserName) {
        switch (browserName) {
            case "chrome" -> DriverManager.launchChrome();
            case "firefox" -> DriverManager.launchFirefox();
            case "edge" -> DriverManager.launchEdge();
            default -> throw new IllegalStateException("Unexpected value: " + browserName);
        }
        System.out.println("URL: " + ConfigUtils.get_URI());
        DriverManager.navigate(ConfigUtils.get_URI());
    }

    @AfterMethod
    public void takesScreenshots(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                Helper.captureScreenshot(DriverManager.getDriver(), result.getName() + "-Failed");
            } catch (IOException e) {
                ExceptionHandling.handleException(e);
                ;
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            try {
                Helper.captureScreenshot(DriverManager.getDriver(), result.getName() + "-Passed");
            } catch (IOException e) {
                ExceptionHandling.handleException(e);
            }
        }
    }

    @AfterSuite
    public void tearDownDriver() {
        DriverManager.quit();
    }
}