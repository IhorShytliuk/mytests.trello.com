package regression;

import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        BoardsPage boardsPage = new BoardsPage();

        loginPage.login("shytliuk.ihor+2@pdffiller.team", "qwe1rty2");
        boardsPage.openBoardByName("qwe");

        System.out.println();

//        Assert.assertTrue(new HeaderPage().isHeaderPresent());
//        Assert.assertFalse(driver.findElements(By.cssSelector(".mod-add")).isEmpty(), "Board page not opened");
    }
}
