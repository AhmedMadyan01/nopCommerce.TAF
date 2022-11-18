package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NotebooksPage;
import utilities.test_base.TestBase;

public class NotebookHoverMenuTest extends TestBase {
    HomePage homePage;
    NotebooksPage notebooksPage;

    @Test
    public void UserCanOpenNotebooksHoverMenu() {
        homePage = new HomePage(driver);
        notebooksPage = new NotebooksPage(driver);
        HomePage.openHomePage();
        homePage.openNotebooksMenu();
        Assert.assertTrue(NotebooksPage.notebookHeaderText.getText().contains("Notebooks"));
    }
}
