package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends PageBase{
    public CategoriesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong")
    public WebElement categories;
}
