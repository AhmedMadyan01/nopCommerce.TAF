package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

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
        setTxtElement(reviewTitleTxtBox, title);
        setTxtElement(reviewTextTxtBox, text);
        clickOnElement(ratingOptionsRdBtn);
        clickOnElement(submitReviewBtn);
    }
}
