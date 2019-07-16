package junk;

import com.trello.api.TrelloRestClient;
import com.trello.api.models.Board;
import com.trello.api.models.Card;
import com.trello.api.models.Label;
import com.trello.api.models.TList;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Api tests")
public class TryTrelloApi {

    TrelloRestClient client = new TrelloRestClient();

    @Story("Board story")
    @Step("Board test")
    @Test
    public void testBoard() throws IOException {
        Board newBoard = new Board();
        newBoard.setName("NewTestBoard");

        Board createdBoard = client.boardsService.createBoard(newBoard.getName()).execute().body();
        System.out.println(createdBoard);

        createdBoard.setName("NewUpdatedTestBoard");
        Board updatedBoard = client.boardsService.updateBoard(createdBoard.getId(), createdBoard).execute().body();
        System.out.println(updatedBoard);

        Board boardInfo = client.boardsService.getBoard(createdBoard.getId()).execute().body();
        System.out.println(boardInfo);

        client.boardsService.deleteBoard(createdBoard.getId()).execute();
    }

    @Step("List test")
    @Test
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

    @Test
    public void testLabel() throws IOException {
        Label newLabel = new Label();
        newLabel.setName("NewTestlabel");
        newLabel.setIdBoard("5ce6a22a552fb28b6b63280d");
        newLabel.setColor("orange");

        Label createdLabel = client.labelsService.createLabel(newLabel.getName(), newLabel.getIdBoard(), newLabel.getColor()).execute().body();
        System.out.println(createdLabel);

        createdLabel.setName("NewUpdatedTestlabel");
        Label updatedlabel = client.labelsService.updateLabel(createdLabel.getId(), createdLabel).execute().body();
        System.out.println(updatedlabel);

        Label labelInfo = client.labelsService.getLabel(createdLabel.getId()).execute().body();
        System.out.println(labelInfo);

        labelInfo = client.labelsService.deleteLabel(createdLabel.getId()).execute().body();
        System.out.println(labelInfo);

    }

    @Test
    public void testCard() throws IOException {
        Card newCard = new Card();
        newCard.setName("NewTestCard");

        Card createdCard = client.cardsService.createCard("5cf69c705f4faf2292b8fdce", newCard).execute().body();
        System.out.println(createdCard);

        createdCard.setName("NewUpdatedTestCard");
        Card updatedCard = client.cardsService.updateCard(createdCard.getId(), createdCard).execute().body();
        System.out.println(updatedCard);

        Card cardInfo = client.cardsService.getCard(createdCard.getId()).execute().body();
        System.out.println(cardInfo);

        client.cardsService.deleteCard(createdCard.getId()).execute();
    }

}
