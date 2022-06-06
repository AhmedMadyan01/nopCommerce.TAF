package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareProductsPage extends PageBase {
    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "table.compare-products-table")
    WebElement compareTable;

    @FindBy(css = "div.no-data")
    WebElement noData;

    @FindBy(tagName = "tr")
    List<WebElement> rows;

    @FindBy(tagName = "td")
    List<WebElement> cols;

    @FindBy(css = "a.clear-list")
    WebElement clearList;

    public void clearCompareList() {
        clickOnElement(clearList);
    }

    public void compareProduct() {
        System.out.println(rows.size());
        for (WebElement row : rows) {
            System.out.println(row.getText() + "\t");
        }
    }
}
