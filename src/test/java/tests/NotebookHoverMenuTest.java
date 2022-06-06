package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NotebooksPage;

public class NotebookHoverMenuTest extends TestBase {
    HomePage homePage;
    NotebooksPage notebooksPage;

    @Test
    public void UserCanOpenNotebooksHoverMenu() {
        homePage = new HomePage(driver);
        notebooksPage = new NotebooksPage(driver);
        homePage.openHomePage();
        homePage.openNotebooksMenu();
        Assert.assertTrue(notebooksPage.notebookHeaderText.getText().contains("Notebooks"));
    }
}
