package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotebooksPage extends PageBase{
    public NotebooksPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "h1")
    public WebElement notebookHeaderText;
}
