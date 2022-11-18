package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.actions.ElementActions;

public class ProductReviewPage   {
    private static final By categories = By.xpath("/html/body/div[6]/div[3]/div[2]/div[1]/div[1]/div[1]/strong");

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleTxtBox;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTextTxtBox;
    @FindBy(id = "addproductrating_3")
    WebElement ratingOptionsRdBtn;
    @FindBy(css = "input.button-1.write-product-review-button")
    WebElement submitReviewBtn;
    @FindBy(css = "div.result")
    public WebElement reviewAddedMessage;

    public void reviewProduct(String title, String text, String rate) {
        ElementActions.sendKeys(reviewTitleTxtBox, title);
        ElementActions.sendKeys(reviewTextTxtBox, text);
        ElementActions.click(ratingOptionsRdBtn);
        ElementActions.click(submitReviewBtn);
    }
}
