package utilities.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;
import utilities.waits.Waits;

public class ElementActions {

    public static WebElement findElement(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            Waits.waitForElementToBeClickable(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return DriverManager.getDriver().findElement(elementLocator);
    }

    public static void click(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            Waits.waitForElementToBeClickable(elementLocator);
            DriverManager.getDriver().findElement(elementLocator).click();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void sendKeys(By elementLocator, String text) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            DriverManager.getDriver().findElement(elementLocator).sendKeys(text);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void clear(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            DriverManager.getDriver().findElement(elementLocator).clear();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void selectByVisibleText(By elementLocator, String visibleText) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            new Select(findElement(elementLocator)).selectByVisibleText(visibleText);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void selectByValue(By elementLocator, String value) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            new Select(findElement(elementLocator)).selectByValue(value);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void selectByIndex(By elementLocator, int index) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            new Select(findElement(elementLocator)).selectByIndex(index);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }
}