package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class OrderInformation   {
    public static final By print = By.linkText("Print");
    public static final By PDFInvoiceLink = By.linkText("PDF Invoice");


    public static void printOrder(){
        ElementActions.click(print);
    }

    public static void downloadPDFInvoice(){
        ElementActions.click(PDFInvoiceLink);
    }
}
