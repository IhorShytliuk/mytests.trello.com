package regression;

import com.trello.api.TrelloRestClient;
import com.trello.api.enums.PermissionsLevel;
import com.trello.api.models.Board;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.BoardsPage;
import com.trello.ui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardPermissionTest extends BrowserFactory {

    @BeforeTest
    public void setUp() {
        new LoginPage().login("shytliuk.ihor+2@pdffiller.team", "qwe1rty2");
    }

    TrelloRestClient client = new TrelloRestClient();

    @DataProvider
    public Iterator<Object[]> boardsProvider() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"TestPublicBoard", PermissionsLevel.PUBLIC});
        list.add(new Object[]{"TestPrivateBoard", PermissionsLevel.PRIVATE});

        return list.iterator();
    }

    @Test(dataProvider = "boardsProvider")
    public void testPermissions(String boardName, PermissionsLevel permissionsLevel) throws IOException {

        Board board = new Board();
        board.setName(boardName);
        board.setPermissionLevel(permissionsLevel.toString());
        board = client.boardsService.createBoard(board).execute().body();

        BoardsPage boardsPage = new BoardsPage();
        boardsPage.openBoardByUrl(board.getUrl());

        System.out.println(board);
        System.out.println(boardsPage.getPermissionsLevel());
        client.boardsService.deleteBoard(board.getId()).execute();

        Assert.assertEquals(boardsPage.getPermissionsLevel().toString(), permissionsLevel.toString());

    }

}
