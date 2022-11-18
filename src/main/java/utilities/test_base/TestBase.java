package utilities.test_base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.time.Duration;

public abstract class TestBase {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    @Parameters({"browser"})
    public static void setDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void takesScreenshots(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenshot(driver, result.getName() + "-Failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Helper.captureScreenshot(driver, result.getName() + "-Passed");
        }
    }

    @AfterSuite
    public void tearDownDriver() {
        driver.quit();
    }
}
