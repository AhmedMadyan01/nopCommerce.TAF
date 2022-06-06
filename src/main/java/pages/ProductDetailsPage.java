package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ProductDetailsPage extends PageBase {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "strong.current-item")
    public WebElement currentProduct;

    @FindBy(css = "input.button-2.email-a-friend-button")
    WebElement emailFriendBtn;

    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn;

    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishListBtn;

    @FindBy(css = "input.button-2.add-to-compare-list-button")
    WebElement addToCompareListBtn;

    @FindBy(css = "div.prices")
    public WebElement productPriceValue;

    @FindBy(linkText = "Add your review")
    WebElement addYourReview;

    public void openEmailFriendPage() {
        clickOnElement(emailFriendBtn);
    }

    public void addToWishList() throws InterruptedException {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("scrollBy(0,400)");
        clickOnElement(addToWishListBtn);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void addToCompareList() throws InterruptedException {
        clickOnElement(addToCompareListBtn);
        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void addToCar() throws InterruptedException {
        clickOnElement(addToCartBtn);
        Thread.sleep(5000);
    }

    public void openAddReviewPage() {
        clickOnElement(addYourReview);
    }

    public void openCompareProductPage() {
        driver.get("https://demo.nopcommerce.com/compareproducts");
    }

}
