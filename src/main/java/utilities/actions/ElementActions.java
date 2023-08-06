package utilities.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.driver_manager.DriverManager;
import utilities.exception_handling.ExceptionHandling;
import utilities.waits.Waits;

import java.util.List;

public class ElementActions {

    public static WebElement findElement(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return DriverManager.getDriver().findElement(elementLocator);
    }

    public static List<WebElement> findElements(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return DriverManager.getDriver().findElements(elementLocator);
    }

    public static void click(By elementLocator) {
        try {
            findElement(elementLocator);
            Waits.waitForElementToBeClickable(elementLocator);
            DriverManager.getDriver().findElement(elementLocator).click();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void forceClick(By elementLocator) {
        try {
            findElement(elementLocator);
            Waits.waitForElementToBeClickable(elementLocator);
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", findElement(elementLocator));
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void sendKeys(By elementLocator, String text) {
        try {
            findElement(elementLocator);
            DriverManager.getDriver().findElement(elementLocator).sendKeys(text);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void clear(By elementLocator) {
        try {
            findElement(elementLocator);
            DriverManager.getDriver().findElement(elementLocator).clear();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void selectByVisibleText(By elementLocator, String visibleText) {
        try {
            findElement(elementLocator);
            new Select(findElement(elementLocator)).selectByVisibleText(visibleText);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void selectByValue(By elementLocator, String value) {
        try {
            findElement(elementLocator);
            new Select(findElement(elementLocator)).selectByValue(value);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static void selectByIndex(By elementLocator, int index) {
        try {
            findElement(elementLocator);
            new Select(findElement(elementLocator)).selectByIndex(index);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static String getText(By elementLocator) {
        try {
            findElement(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return DriverManager.getDriver().findElement(elementLocator).getText();
    }

    public static String getAttribute(By elementLocator, String attribute) {
        try {
            findElement(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return DriverManager.getDriver().findElement(elementLocator).getAttribute(attribute);
    }

    public static void scrollIntoView(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
            new Actions(DriverManager.getDriver()).scrollToElement(findElement(elementLocator)).perform();
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
    }

    public static Actions moveToElement(By elementLocator) {
        try {
            Waits.waitForElementToBeVisible(elementLocator);
        } catch (Exception exception) {
            ExceptionHandling.handleException(exception);
        }
        return new Actions(DriverManager.getDriver()).moveToElement(findElement(elementLocator));
    }
}