package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.actions.ElementActions;

import java.util.List;

public class SearchPage {
    private static final By searchTxtBox = By.id("small-searchterms");
    private static final By searchBtn = By.xpath("//button[@class='button-1 search-box-button']");
    @FindBy(css = "li.ui-menu-item")
    static
    List<WebElement> autoSuggestSearchMenu;

    public static void searchProduct(String product) {
        ElementActions.sendKeys(searchTxtBox, product);
        ElementActions.click(searchBtn);
    }

    public static void searchProductByAutoSuggest(String product) {
        ElementActions.sendKeys(searchTxtBox, product);
        autoSuggestSearchMenu.get(0).click();
    }
}