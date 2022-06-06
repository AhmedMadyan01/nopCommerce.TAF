package tests;

import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareProductsTest extends TestBase {
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    CompareProductsPage compareProductsPage;
    String product1 = "HTC One Mini Blue";
    String product2 = "HTC One M8 Android L 5.0 Lollipop";

    @Test(priority = 1)
    public void UserCanAddProduct1ToCompareList() throws InterruptedException {
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        compareProductsPage = new CompareProductsPage(driver);

        homePage.openHomePage();
        searchPage.searchProductByAutoSuggest(product1);
        productDetailsPage.addToCompareList();

        homePage.openHomePage();
        searchPage.searchProductByAutoSuggest(product2);
        productDetailsPage.addToCompareList();
        productDetailsPage.openCompareProductPage();
    }

    @Test(priority = 2, dependsOnMethods = "UserCanAddProduct1ToCompareList")
    public void UserCanClearCompareList() {
        compareProductsPage = new CompareProductsPage(driver);
        compareProductsPage.compareProduct();
        compareProductsPage.clearCompareList();
    }
}
