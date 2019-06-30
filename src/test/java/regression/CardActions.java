package regression;

import com.trello.api.models.Card;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.CardPage;
import com.trello.ui.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;

public class CardActions {

    public LoginPage loginPage = new LoginPage();
    public BoardsPage boardsPage = new BoardsPage();
    public CardPage cardPage = new CardPage();

    Card card = new Card("Test_Card_" + new Date().getTime());

    @Test
    public void login() {
        loginPage.open();
        loginPage.login("qwe@i.ua", "qwe1rty2");
    }

    @Test
    public void openCard() {

    }

    @Test
    public void moveCard() {

    }

    @BeforeTest
    public void initData() {
        //todo create card
    }

    @AfterTest
    public void clearData() {
        //todo delete card

    }

}
