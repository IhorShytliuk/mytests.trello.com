package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.ui.core.BrowserFactory.get;
import static com.trello.ui.core.Constants.URL;

public class BoardsPage {

    public static final String PATH = "boards";

    private Elem createBoardBtnBy = new Elem(By.xpath("//div[@class='board-tile mod-add']/p"), "CreateBoardBtn");

    private By boardTitleInpBy = By.xpath("//input[@class='subtle-input']");
    private By createBoardWithNameBtnBy = By.xpath("//button[@class='primary']");

    private By homeBtnBy = By.xpath("//a[@class='header-btn js-back-menu']");
    private By showMenuBtnBy = By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']");
    private By showMoreBtnBy = By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']");
    private By closeBoardBtnBy = By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']");

    private By closeInpBy = By.xpath("//input[@class='js-confirm full negate']");
    private By deleteBoardBy = By.xpath("//p[@class='delete-container']/a");

    private By favouriteAddBy = By.xpath("//*[@class='board-header-btn js-star-board']");
    private By favouriteDelBy = By.xpath("//*[@class='board-header-btn js-star-board board-header-btn-enabled']");

    public void open() {
        get(URL + PATH);
        Assert.assertTrue(isOpened(), "Page 'Login' " + PATH + " is not Opened");
    }

    public boolean isOpened() {
        return createBoardBtnBy.isElementPresent();
    }

//    public boolean isLoggedOut() {
//        return driver.getCurrentUrl().contains("logged-out");
//    }


    public void openBoardByName(String boardName) {
        open();
        Elem board = new Elem(By.xpath("//div[contains(text(),'" + boardName + "')]/ancestor::a"));
        board.click();
    }

    //todo
    public void openBoardByUrl(String boardName) {
        open();
        Elem board = new Elem(By.xpath("//div[contains(text(),'" + boardName + "')]/ancestor::a"));
        board.click();
    }

}
