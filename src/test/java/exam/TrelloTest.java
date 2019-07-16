package exam;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.TList;
import com.trello.ui.core.BrowserFactory;
import com.trello.ui.pages.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TrelloTest extends BrowserFactory {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("shytliuk.ihor+2@pdffiller.team", "qwe1rty2");
        Assert.assertTrue(loginPage.isLogined());
    }

    @Test(dependsOnMethods = "loginTest")
    public void logoutTest() {
        LoginPage page = new LoginPage();
        page.logout();
        Assert.assertTrue(page.isLoggedOut());
    }

    TrelloRestClient client = new TrelloRestClient();
    String testBoardID = "5ce6a22a552fb28b6b63280d";
    String listName;
    TList createdTList;

    @Step("Create list")
    @Test
    public void createTList() throws IOException {

        listName = "NewList" + new Date().getTime();

        TList newTList = new TList();
        newTList.setName(listName);
        newTList.setIdBoard(testBoardID);

        createdTList = client.listsService.createList(newTList.getName(), newTList.getIdBoard()).execute().body();

        List<TList> boardLists = client.boardsService.getBoardLists(testBoardID).execute().body();
        boolean boardPresent = isListPresent(boardLists, listName);
        Assert.assertTrue(boardPresent);
    }

    @Step("Create list")
    @Test(dependsOnMethods = "createTList")
    public void copyTList() throws IOException {

        String copiedListName = listName + "Copy";

//        TList newTList = new TList();
//        newTList.setName(listName);
//        newTList.setIdBoard(testBoardID);

        TList copiedTList = client.listsService.createList(copiedListName, createdTList.getIdBoard()).execute().body();

        List<TList> boardLists = client.boardsService.getBoardLists(testBoardID).execute().body();
        boolean boardPresent = isListPresent(boardLists, copiedListName);
        Assert.assertTrue(boardPresent);
        copiedTList.setClosed(true);
        client.listsService.updateList(copiedTList.getId(), copiedTList).execute().body();
    }


    @Step("Delete list")
    @Test(dependsOnMethods = "createTList")
    public void deleteTList() throws IOException {
        TList newTList = new TList();
        newTList.setName(listName);
        newTList.setIdBoard(testBoardID);

        createdTList.setClosed(true);
        client.listsService.updateList(createdTList.getId(), createdTList).execute().body();

        List<TList> boardLists = client.boardsService.getBoardLists(testBoardID).execute().body();
        boolean boardPresent = isListPresent(boardLists, listName);
        Assert.assertFalse(boardPresent);
    }

    private boolean isListPresent(List<TList> boardLists, String listName) {
        boolean boardPresent = false;

        for (TList tlist : boardLists) {
            if (tlist.getName().equals(listName)) {
                boardPresent = true;
            }
        }

        return boardPresent;
    }

    //    @Step("List test")
//    @Test
    public void testTList() throws IOException {
        TList newTList = new TList();
        newTList.setName("NewTestTList");
        newTList.setIdBoard("5ce6a22a552fb28b6b63280d");

        TList createdTList = client.listsService.createList(newTList.getName(), newTList.getIdBoard()).execute().body();
        System.out.println(createdTList);

        createdTList.setName("NewUpdatedTestTList");
        TList updatedTList = client.listsService.updateList(createdTList.getId(), createdTList).execute().body();
        System.out.println(updatedTList);

        TList listInfo = client.listsService.getList(createdTList.getId()).execute().body();
        System.out.println(listInfo);

        createdTList.setClosed(true);
        listInfo = client.listsService.updateList(createdTList.getId(), createdTList).execute().body();
        System.out.println(listInfo);
    }
}
