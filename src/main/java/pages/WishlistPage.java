package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class WishlistPage {
    private static final By removeFromCartCheckBox = By.name("removefromcart");
    private static final By updateCart = By.name("updatecart");

    public static void removeFromCart() {
        ElementActions.click(removeFromCartCheckBox);
        ElementActions.click(updateCart);
    }
}
