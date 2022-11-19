package tests;

import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import utilities.test_base.TestBase;

public class CompareProductsTest extends TestBase {
    String product1 = "HTC One Mini Blue";
    String product2 = "HTC One M8 Android L 5.0 Lollipop";

    @Test(priority = 1)
    public void UserCanAddProduct1ToCompareList() throws InterruptedException {


        HomePage.openHomePage();
        SearchPage.searchProductByAutoSuggest(product1);
        ProductDetailsPage.addToCompareList();

        HomePage.openHomePage();
        SearchPage.searchProductByAutoSuggest(product2);
        ProductDetailsPage.addToCompareList();
        ProductDetailsPage.openCompareProductPage();
    }

    @Test(priority = 2, dependsOnMethods = "UserCanAddProduct1ToCompareList")
    public void UserCanClearCompareList() {
        CompareProductsPage.compareProduct();
        CompareProductsPage.clearCompareList();
    }
}
