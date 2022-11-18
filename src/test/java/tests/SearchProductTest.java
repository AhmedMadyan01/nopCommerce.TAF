package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class SearchProductTest extends TestBase {
    @DataProvider(name = "product")
    public static Object[][] productName() {
        return new Object[][]
                {{"Apple MacBook Pro 13-inch"},
                        {"Apple MacBook Pro 13-inch"}};
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "product")
    public void UserCanRegisterSuccessfully(String product) {
        /*
         * 1- Search Product
         * */
        HomePage.openHomePage();
        SearchPage.searchProduct(product);
        SearchResultPage.openProductPageDetails();
        Assert.assertTrue(ElementActions.getText(ProductDetailsPage.currentProduct).contains(product));
    }
}
