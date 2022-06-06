package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchProductTest extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    SearchResultPage searchResultPage;
    ProductDetailsPage productDetailsPage;

    @DataProvider(name = "product")
    public static Object[][] productName() {
        return new Object[][]
                {{"Apple MacBook Pro 13-inch"},
                        {"Apple MacBook Pro 13-inch"}};
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "product")
    public void UserCanRegisterSuccessfully(String product) {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchResultPage = new SearchResultPage(driver);
        /*
         * 1- Search Product
         * */
        homePage.openHomePage();
        searchPage.searchProduct(product);
        searchResultPage.openProductPageDetails();
        Assert.assertTrue(productDetailsPage.currentProduct.getText().contains(product));
    }
}
