package utilities.driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.exception_handling.ExceptionHandling;

import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static WebDriver driver = null;

    public static void launchChrome() {
        try {
            driver = new ChromeDriver();
            maximizeWindow();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void launchFirefox() {
        try {
            driver = new FirefoxDriver();
            maximizeWindow();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void launchEdge() {
        try {
            driver = new EdgeDriver();
            maximizeWindow();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void maximizeWindow() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void navigate(String url) {
        try {
//            driver.get(url);
            driver.navigate().to(new URL(url));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quit() {
        try {
            driver.quit();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
}
