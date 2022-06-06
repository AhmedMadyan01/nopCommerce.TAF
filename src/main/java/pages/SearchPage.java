package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;
    @FindBy(css = "input.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(css = "li.ui-menu-item")
    List<WebElement> autoSuggestSearchMenu;


    public void searchProduct(String product) {
        setTxtElement(searchTxtBox, product);
        clickOnElement(searchBtn);
    }
    public void searchProductByAutoSuggest(String product) {
        setTxtElement(searchTxtBox, product);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        autoSuggestSearchMenu.get(0).click();
    }
}
