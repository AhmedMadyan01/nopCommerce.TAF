package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class ProductReviewPage {
    private static final By reviewTitleTxtBox = By.id("AddProductReview_Title");
    private static final By reviewTextTxtBox = By.id("AddProductReview_ReviewText");
    private static final By ratingOptionsRdBtn = By.id("addproductrating_3");
    private static final By submitReviewBtn = By.cssSelector("input.button-1.write-product-review-button");
    public static final By reviewAddedMessage = By.cssSelector("div.result");

    public static void reviewProduct(String title, String text, String rate) {
        ElementActions.sendKeys(reviewTitleTxtBox, title);
        ElementActions.sendKeys(reviewTextTxtBox, text);
        ElementActions.click(ratingOptionsRdBtn);
        ElementActions.click(submitReviewBtn);
    }
}