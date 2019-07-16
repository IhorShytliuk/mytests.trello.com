package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;

import static com.trello.ui.core.BrowserFactory.getCurrentUrl;

public class BasePage {
    private Elem profileBtnBy = new Elem(By.xpath("//*[@data-test-id='header-member-menu-button']"));
    private Elem logoutBtnBy = new Elem(By.xpath("//*[@data-test-id='header-member-menu-logout']"));

    public void logout() {
        profileBtnBy.click();
        logoutBtnBy.click();
    }

    public boolean isLoggedOut() {
        return getCurrentUrl().contains("logged-out");
    }
}
