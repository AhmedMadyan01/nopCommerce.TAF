package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void setDriver(@Optional("firefox") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            String driverPath;
            driverPath = (System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            String driverPath;
            //driverPath = (System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void takesScreenshots(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Helper.captureScreenshot(driver, result.getName() + "-Failed");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Helper.captureScreenshot(driver, result.getName() + "-Passed");
        }
    }

    @AfterSuite
    public void stopDriver() {
        driver.quit();
    }
}
