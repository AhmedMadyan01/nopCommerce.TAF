package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.actions.ElementActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage   {
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");

    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;
    @FindBy(css = "input.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(css = "li.ui-menu-item")
    List<WebElement> autoSuggestSearchMenu;


    public void searchProduct(String product) {
        ElementActions.sendKeys(searchTxtBox, product);
        ElementActions.click(searchBtn);
    }
    public static void searchProductByAutoSuggest(String product) {
        ElementActions.sendKeys(searchTxtBox, product);
        autoSuggestSearchMenu.get(0).click();
    }
}
