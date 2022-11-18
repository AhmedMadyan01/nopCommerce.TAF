package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Actions.ElementActions;

public class CheckoutPage extends PageBase {

    private static final By updateShoppingBtn = By.name("updatecart");
    private static final By continueShoppingBtn = By.name("continueshopping");
    private static final By termsOfServiceCheckBox = By.name("termsofservice");
    private static final By removeCheckBox = By.name("removefromcart");
    private static final By price = By.cssSelector("span.product-unit-price");
    private static final By total = By.cssSelector("span.product-subtotal");
    private static final By quantity = By.cssSelector("input.qty-input");
    private static final By checkout = By.id("checkout");
    public static final By emptyCartCheck = By.cssSelector("div.no-data");
    private static final By productName = By.cssSelector("a.product-name");
    private static final By billingNewAddressFirstName = By.id("BillingNewAddress_FirstName");
    private static final By billingNewAddressLastName = By.id("BillingNewAddress_LastName");
    private static final By billingNewAddressEmail = By.id("BillingNewAddress_Email");
    private static final By billingNewAddressCountryId = By.id("BillingNewAddress_CountryId");
    private static final By billingNewAddress_City = By.id("BillingNewAddress_City");
    private static final By billingNewAddress_Address1 = By.id("BillingNewAddress_Address1");
    private static final By billingNewAddress_ZipPostalCode = By.id("BillingNewAddress_ZipPostalCode");
    private static final By billingNewAddress_PhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    private static final By continue1 = By.cssSelector("input.button-1.new-address-next-step-button");
    private static final By continue2 = By.cssSelector("input.button-1.new-address-next-step-button");
    private static final By continue3 = By.cssSelector("input.button-1.shipping-method-next-step-button");
    private static final By continue4 = By.cssSelector("input.button-1.payment-method-next-step-button");
    private static final By continue5 = By.cssSelector("input.button-1.payment-info-next-step-button");
    private static final By confirmBtn = By.cssSelector("input.button-1.confirm-order-next-step-button");
    private static final By checkoutAsGuestBtn = By.cssSelector("input.button-1.checkout-as-guest-button");
    private static final By checkoutCompletedMessage = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
    private static final By orderInformationPageLink = By.linkText("Click here for order details.");

    public void removeFormCart() {
        ElementActions.click(removeCheckBox);
        ElementActions.click(updateShoppingBtn);
    }

    public void continueShopping() {
        ElementActions.click(continueShoppingBtn);
    }

    public void checkoutAsRegisteredUser(String fName, String lName, String email, String country, String city,
                                         String address, String zipCode, String phoneNumber) throws InterruptedException {
        ElementActions.click(termsOfServiceCheckBox);
        ElementActions.click(checkout);
        ElementActions.sendKeys(billingNewAddressFirstName, fName);
        ElementActions.sendKeys(billingNewAddressLastName, lName);
        ElementActions.clear(billingNewAddressEmail);
        ElementActions.sendKeys(billingNewAddressEmail, email);
        ElementActions.selectByVisibleText(billingNewAddressCountryId,country);
        ElementActions.sendKeys(billingNewAddress_City, city);
        ElementActions.sendKeys(billingNewAddress_Address1, address);
        ElementActions.sendKeys(billingNewAddress_ZipPostalCode, zipCode);
        ElementActions.sendKeys(billingNewAddress_PhoneNumber, phoneNumber);
        ElementActions.click(continue1);
        ElementActions.click(continue2);
        ElementActions.click(continue3);
        ElementActions.click(continue4);
        ElementActions.click(continue5);
        ElementActions.click(confirmBtn);
    }

    public void checkoutAsGuestUser(String fName, String lName, String email, String country, String city,
                                    String address, String zipCode, String phoneNumber) throws InterruptedException {
        ElementActions.click(termsOfServiceCheckBox);
        ElementActions.click(checkout);
        ElementActions.click(checkoutAsGuestBtn);
        ElementActions.sendKeys(billingNewAddressFirstName, fName);
        ElementActions.sendKeys(billingNewAddressLastName, lName);
        ElementActions.clear(billingNewAddressEmail);
        ElementActions.sendKeys(billingNewAddressEmail, email);
        ElementActions.selectByVisibleText(billingNewAddressCountryId,country);
        ElementActions.sendKeys(billingNewAddress_City, city);
        ElementActions.sendKeys(billingNewAddress_Address1, address);
        ElementActions.sendKeys(billingNewAddress_ZipPostalCode, zipCode);
        ElementActions.sendKeys(billingNewAddress_PhoneNumber, phoneNumber);
        ElementActions.click(continue1);
        ElementActions.click(continue2);
        ElementActions.click(continue3);
        ElementActions.click(continue4);
        ElementActions.click(continue5);
        ElementActions.click(confirmBtn);
    }

    public void changeQuantity(int q) {
        ElementActions.clear(quantity);
        ElementActions.sendKeys(quantity, Integer.toString(q));
        ElementActions.click(updateShoppingBtn);
    }

    public void openOrderInformationPage() {
        ElementActions.click(orderInformationPageLink);
    }
}
