package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;
import utilities.driver_manager.DriverManager;

public class HomePage {

    public static final By registerLink = By.linkText("Register");

    public static final By loginLink = By.linkText("Log in");

    public static final By logoutLink = By.linkText("Log out");

    public static final By myAccountLink = By.linkText("My account");

    public static final By contactUsLink = By.linkText("Contact us");

    public static final By changeCurrencyList = By.id("customerCurrency");

    public static final By shoppingCart = By.cssSelector("span.cart-label");


    public static final By wishlist = By.cssSelector("a.ico-wishlist");

    public static final By computersMenu = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");

    public static final By notebooksMenu = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a");


    public static void openHomePage() {
        DriverManager.navigate("https://demo.nopcommerce.com/");
    }

    public static void openRegistrationPage() {
        ElementActions.click(registerLink);
    }

    public void openLoginPage() {
        ElementActions.click(loginLink);
    }

    public static void userLogout() {
        ElementActions.click(logoutLink);
    }

    public void openMyAccountPage() {
        ElementActions.click(myAccountLink);
    }

    public void openContactUsPage() {
        ElementActions.click(contactUsLink);
    }

    public void changeCurrency(String currency) {
        if (currency.equals("us")) {
            ElementActions.selectByIndex(changeCurrencyList, 0);
        } else if (currency.equals("euro")) {
            ElementActions.selectByIndex(changeCurrencyList, 1);
        }
    }

    public void openNotebooksMenu() {
        ElementActions.moveToElement(computersMenu)
                .moveToElement(ElementActions.findElement(notebooksMenu))
                .click()
                .build()
                .perform();
    }

    public void openWishlistPage() {
        DriverManager.navigate("https://demo.nopcommerce.com/wishlist");
    }

    public static void openShoppingCart() {
        ElementActions.click(shoppingCart);
    }
}
