package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PageBase{
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (linkText = "Apple MacBook Pro 13-inch")
    WebElement productLink;

    public void openProductPageDetails(){
        clickOnElement(productLink);
    }
}
