package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class CheckoutPage extends PageBase {

    public static final By updateShoppingBtn = By.name("updatecart");
    public static final By continueShoppingBtn = By.name("continueshopping");
    public static final By termsOfServiceCheckBox = By.name("termsofservice");
    public static final By removeCheckBox = By.name("removefromcart");
    public static final By price = By.cssSelector("span.product-unit-price");
    public static final By total = By.cssSelector("span.product-subtotal");
    public static final By quantity = By.cssSelector("input.qty-input");
    public static final By checkout = By.id("checkout");
    public static final By emptyCartCheck = By.cssSelector("div.no-data");
    public static final By productName = By.cssSelector("a.product-name");
    public static final By billingNewAddressFirstName = By.id("BillingNewAddress_FirstName");
    public static final By billingNewAddressLastName = By.id("BillingNewAddress_LastName");
    public static final By billingNewAddressEmail = By.id("BillingNewAddress_Email");
    public static final By billingNewAddressCountryId = By.id("BillingNewAddress_CountryId");
    public static final By billingNewAddress_City = By.id("BillingNewAddress_City");
    public static final By billingNewAddress_Address1 = By.id("BillingNewAddress_Address1");
    public static final By billingNewAddress_ZipPostalCode = By.id("BillingNewAddress_ZipPostalCode");
    public static final By billingNewAddress_PhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    public static final By continue1 = By.cssSelector("input.button-1.new-address-next-step-button");
    public static final By continue2 = By.cssSelector("input.button-1.new-address-next-step-button");
    public static final By continue3 = By.cssSelector("input.button-1.shipping-method-next-step-button");
    public static final By continue4 = By.cssSelector("input.button-1.payment-method-next-step-button");
    public static final By continue5 = By.cssSelector("input.button-1.payment-info-next-step-button");
    public static final By confirmBtn = By.cssSelector("input.button-1.confirm-order-next-step-button");
    public static final By checkoutAsGuestBtn = By.cssSelector("input.button-1.checkout-as-guest-button");
    public static final By checkoutCompletedMessage = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
    public static final By orderInformationPageLink = By.linkText("Click here for order details.");

    public void removeFormCart() {
        ElementActions.click(removeCheckBox);
        ElementActions.click(updateShoppingBtn);
    }

    public void continueShopping() {
        ElementActions.click(continueShoppingBtn);
    }

    public static void checkoutAsRegisteredUser(String fName, String lName, String email, String country, String city,
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

    public static void changeQuantity(int q) {
        ElementActions.clear(quantity);
        ElementActions.sendKeys(quantity, Integer.toString(q));
        ElementActions.click(updateShoppingBtn);
    }

    public static void openOrderInformationPage() {
        ElementActions.click(orderInformationPageLink);
    }
}
