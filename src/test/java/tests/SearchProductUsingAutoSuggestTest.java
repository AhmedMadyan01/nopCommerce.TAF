package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggestTest extends TestBase {
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;

    @DataProvider(name = "product")
    public static Object[][] productName() {
        return new Object[][]
                {{"Apple MacBook Pro 13-inch"},
                        {"Apple MacBook Pro 13-inch"}};
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "product")
    public void UserCanRegisterSuccessfully(String product) {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        /*
         * 1- Search Product
         * */
        searchPage.searchProductByAutoSuggest(product);
        Assert.assertTrue(productDetailsPage.currentProduct
                .getText().contains(product));
    }
}
