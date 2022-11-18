package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.actions.ElementActions;

import java.util.List;

public class CompareProductsPage {
    public static final By compareTable = By.cssSelector("table.compare-products-table");
    public static final By clearList = By.cssSelector("a.clear-list");
    public static final By noData = By.cssSelector("div.no-data");
    @FindBy(tagName = "tr")
    List<WebElement> rows;

    @FindBy(tagName = "td")
    List<WebElement> cols;

    public void clearCompareList() {
        ElementActions.click(clearList);
    }

    public void compareProduct() {
        System.out.println(rows.size());
        for (WebElement row : rows) {
            System.out.println(row.getText() + "\t");
        }
    }
}
