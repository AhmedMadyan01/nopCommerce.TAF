package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "updatecart")
    WebElement updateShoppingBtn;

    @FindBy(name = "continueshopping")
    WebElement continueShoppingBtn;

    @FindBy(name = "termsofservice")
    WebElement termsOfServiceCheckBox;

    @FindBy(name = "removefromcart")
    WebElement removeCheckBox;

    @FindBy(css = "span.product-unit-price")
    public WebElement price;

    @FindBy(css = "span.product-subtotal")
    public WebElement total;

    @FindBy(css = "input.qty-input")
    public WebElement quantity;

    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(css = "div.no-data")
    public WebElement emptyCartCheck;

    @FindBy(css = "a.product-name")
    public WebElement productName;

    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement billingNewAddressFirstName;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement billingNewAddressLastName;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement billingNewAddressEmail;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement billingNewAddressCountryId;

    @FindBy(id = "BillingNewAddress_City")
    WebElement billingNewAddress_City;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement billingNewAddress_Address1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement billingNewAddress_ZipPostalCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement billingNewAddress_PhoneNumber;

    @FindBy(css = "input.button-1.new-address-next-step-button")
    WebElement continue1;
    @FindBy(css = "input.button-1.new-address-next-step-button")
    WebElement continue2;
    @FindBy(css = "input.button-1.shipping-method-next-step-button")
    WebElement continue3;
    @FindBy(css = "input.button-1.payment-method-next-step-button")
    WebElement continue4;
    @FindBy(css = "input.button-1.payment-info-next-step-button")
    WebElement continue5;
    @FindBy(css = "input.button-1.confirm-order-next-step-button")
    WebElement confirmBtn;
    @FindBy(css = "input.button-1.checkout-as-guest-button")
    WebElement checkoutAsGuestBtn;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong")
    public WebElement checkoutCompletedMessage;


    @FindBy(linkText = "Click here for order details.")
    WebElement orderInformationPageLink;

    public void removeFormCart() {
        clickOnElement(removeCheckBox);
        clickOnElement(updateShoppingBtn);
    }

    public void continueShopping() {
        clickOnElement(continueShoppingBtn);
    }

    public void checkoutAsRegisteredUser(String fName, String lName, String email, String country, String city,
                                         String address, String zipCode, String phoneNumber) throws InterruptedException {
        clickOnElement(termsOfServiceCheckBox);
        clickOnElement(checkout);
        setTxtElement(billingNewAddressFirstName, fName);
        setTxtElement(billingNewAddressLastName, lName);
        clearTxtElement(billingNewAddressEmail);
        setTxtElement(billingNewAddressEmail, email);
        select = new Select(billingNewAddressCountryId);
        select.selectByVisibleText(country);
        setTxtElement(billingNewAddress_City, city);
        setTxtElement(billingNewAddress_Address1, address);
        setTxtElement(billingNewAddress_ZipPostalCode, zipCode);
        setTxtElement(billingNewAddress_PhoneNumber, phoneNumber);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue2);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue3);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue4);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue5);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(confirmBtn);
    }

    public void checkoutAsGuestUser(String fName, String lName, String email, String country, String city,
                                    String address, String zipCode, String phoneNumber) throws InterruptedException {
        clickOnElement(termsOfServiceCheckBox);
        clickOnElement(checkout);
        clickOnElement(checkoutAsGuestBtn);
        setTxtElement(billingNewAddressFirstName, fName);
        setTxtElement(billingNewAddressLastName, lName);
        clearTxtElement(billingNewAddressEmail);
        setTxtElement(billingNewAddressEmail, email);
        select = new Select(billingNewAddressCountryId);
        select.selectByVisibleText(country);
        setTxtElement(billingNewAddress_City, city);
        setTxtElement(billingNewAddress_Address1, address);
        setTxtElement(billingNewAddress_ZipPostalCode, zipCode);
        setTxtElement(billingNewAddress_PhoneNumber, phoneNumber);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue2);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue3);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue4);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(continue5);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickOnElement(confirmBtn);
    }

    public void changeQuantity(int q) {
        clearTxtElement(quantity);
        setTxtElement(quantity, Integer.toString(q));
        clickOnElement(updateShoppingBtn);
    }

    public void openOrderInformationPage() {
        clickOnElement(orderInformationPageLink);
    }
}
