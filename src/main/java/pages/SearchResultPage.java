package pages;

import org.openqa.selenium.By;
import utilities.actions.ElementActions;

public class SearchResultPage {
    private static final By productLink = By.linkText("Apple MacBook Pro 13-inch");

    public static void openProductPageDetails() {
        ElementActions.click(productLink);
    }
}