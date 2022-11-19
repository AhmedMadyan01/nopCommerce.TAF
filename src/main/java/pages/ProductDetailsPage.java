package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;
import utilities.driver_manager.DriverManager;

public class ProductDetailsPage {
    public static final By currentProduct = By.cssSelector("strong.current-item");
    public static final By emailFriendBtn = By.cssSelector("input.button-2.email-a-friend-button");
    public static final By addToCartBtn = By.id("add-to-cart-button-4");
    public static final By addToWishListBtn = By.id("add-to-wishlist-button-4");
    public static final By addToCompareListBtn = By.cssSelector("input.button-2.add-to-compare-list-button");
    public static final By productPriceValue = By.cssSelector("div.prices");
    public static final By addYourReview = By.linkText("Add your review");

    public static void openEmailFriendPage() {
        ElementActions.click(emailFriendBtn);
    }

    public static void addToWishList() {
        ElementActions.click(addToWishListBtn);
    }

    public static void addToCompareList() {
        ElementActions.click(addToCompareListBtn);
    }

    public static void addToCar() {
        ElementActions.click(addToCartBtn);
    }

    public static void openAddReviewPage() {
        ElementActions.click(addYourReview);
    }

    public static void openCompareProductPage() {
        DriverManager.navigate("https://demo.nopcommerce.com/compareproducts");
    }
}