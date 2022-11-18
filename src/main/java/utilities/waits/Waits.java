package utilities.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.exception_handling.ExceptionHandling;
import utilities.test_base.TestBase;

import java.time.Duration;

public class Waits {
    private static final WebDriverWait webDriverWait = new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(30));


    public static void waitForElementToBeVisible(By elementLocator) {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void waitForElementToBeClickable(By elementLocator) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
}
