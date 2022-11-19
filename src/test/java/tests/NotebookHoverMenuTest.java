package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NotebooksPage;
import utilities.actions.ElementActions;
import utilities.test_base.TestBase;

public class NotebookHoverMenuTest extends TestBase {
    @Test
    public void UserCanOpenNotebooksHoverMenu() {
        HomePage.openHomePage();
        HomePage.openNotebooksMenu();
        Assert.assertTrue(ElementActions.getText(NotebooksPage.notebookHeaderText).contains("Notebooks"));
    }
}