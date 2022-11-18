package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Log out")
    WebElement logoutLink;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(id = "customerCurrency")
    WebElement changeCurrencyList;

    @FindBy(css = "span.cart-label")
    WebElement shoppingCart;

    @FindBy(css = "a.ico-wishlist")
    public WebElement wishlist;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement computersMenu;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
    WebElement notebooksMenu;

    public static void openHomePage() {
        driver.get("https://demo.nopcommerce.com/");
    }

    public static void openRegistrationPage() {
        clickOnElement(registerLink);
    }

    public void openLoginPage() {
        clickOnElement(loginLink);
    }

    public static void userLogout() {
        clickOnElement(logoutLink);
    }

    public void openMyAccountPage() {
        clickOnElement(myAccountLink);
    }

    public void openContactUsPage() {
        clickOnElement(contactUsLink);
    }

    public void changeCurrency(String currency) {
        if (currency.equals("us")) {
            select = new Select(changeCurrencyList);
            select.selectByIndex(0);
            scrollTo("500");
        } else if (currency.equals("euro")) {
            select = new Select(changeCurrencyList);
            select.selectByIndex(1);
            scrollTo("400");
        }
    }

    public void openNotebooksMenu() {
        actions.moveToElement(computersMenu)
                .moveToElement(notebooksMenu)
                .click()
                .build()
                .perform();
    }

    public void openWishlistPage() {
        driver.get("https://demo.nopcommerce.com/wishlist");
    }

    public void openShoppingCart() {
        clickOnElement(shoppingCart);
    }
}
