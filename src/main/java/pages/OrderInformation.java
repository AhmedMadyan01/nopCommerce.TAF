package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderInformation extends PageBase {
    public OrderInformation(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Print")
    WebElement print;

    @FindBy(linkText = "PDF Invoice")
    WebElement PDFInvoiceLink;

    public void printOrder(){
        clickOnElement(print);
    }

    public void downloadPDFInvoice(){
        clickOnElement(PDFInvoiceLink);
    }
}
