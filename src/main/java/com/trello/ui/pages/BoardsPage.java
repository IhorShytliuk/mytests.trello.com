package com.trello.ui.pages;

import com.trello.api.enums.PermissionsLevel;
import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.ui.core.BrowserFactory.get;
import static com.trello.ui.core.Constants.URL;

public class BoardsPage {

    public static final String PATH = "boards";

    private Elem createBoardBtnBy = new Elem(By.xpath("//div[@class='board-tile mod-add']/p"), "CreateBoardBtn");

    private Elem boardTitleInpBy = new Elem(By.xpath("//input[@class='subtle-input']"));
    private Elem createBoardWithNameBtnBy = new Elem(By.xpath("//button[@class='primary']"));

    private Elem homeBtnBy = new Elem(By.xpath("//a[@class='header-btn js-back-menu']"));
    private Elem showMenuBtnBy = new Elem(By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']"));
    private Elem showMoreBtnBy = new Elem(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
    private Elem closeBoardBtnBy = new Elem(By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']"));

    private Elem closeInpBy = new Elem(By.xpath("//input[@class='js-confirm full negate']"));
    private Elem deleteBoardBy = new Elem(By.xpath("//p[@class='delete-container']/a"));

    private Elem favouriteAddBy = new Elem(By.xpath("//*[@class='board-header-btn js-star-board']"));
    private Elem favouriteDelBy = new Elem(By.xpath("//*[@class='board-header-btn js-star-board board-header-btn-enabled']"));
    private Elem permissionsLevel = new Elem(By.xpath("//*[@id='permission-level']/span"));

    public void open() {
        get(URL + PATH);
        Assert.assertTrue(isOpened(), "Page 'Login' " + PATH + " is not Opened");
    }

    public boolean isOpened() {
        return createBoardBtnBy.isElementPresent();
    }

    public void openBoardByName(String boardName) {
        open();
        Elem board = new Elem(By.xpath("//div[contains(text(),'" + boardName + "')]/ancestor::a"));
        board.click();
    }

    public void openBoardByUrl(String url) {
        get(url);
    }

    public PermissionsLevel getPermissionsLevel() {
        return permissionsLevel.getAttributeValue("class").contains("icon-private") ? PermissionsLevel.PRIVATE : PermissionsLevel.PUBLIC;
    }

}
