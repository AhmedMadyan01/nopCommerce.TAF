//package pages;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//
//
//public class PageBase {
//    protected WebDriver driver;
//    public JavascriptExecutor jse;
//    public Select select;
//    public Actions actions;
//
//    protected static void ElementActions.click(WebElement element) {
//        element.click();
//    }
//
//    protected static void ElementActions.sendKeys(WebElement element, String text) {
//        element.sendKeys(text);
//    }
//
//    protected static void clearTxtElement(WebElement element){
//        element.clear();
//    }
//
//    protected static void openPage(WebElement pageLink) {
//        pageLink.click();
//    }
//
//    public void scrollTo(String scroll) {
//        jse = (JavascriptExecutor) driver;
//        jse.executeScript("scrollBy(0," + scroll + ")");
//    }
//}
