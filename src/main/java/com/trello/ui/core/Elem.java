package com.trello.ui.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.trello.ui.core.BrowserFactory.driver;
import static com.trello.ui.core.BrowserFactory.getWebDriwerWait;

public class Elem {

    private By by;
    private String name;

    public Elem(By by, String name) {
        this.by = by;
        this.name = name;
    }


    public Elem(By by) {
        this(by, null);
    }

    public void typeText(String text) {
//        waitForElementPresent(by);
        WebElement element = find();
        element.clear();
        element.sendKeys(text);
    }

    public void click() {
//        waitForElementPresent(by);
        find().click();
    }

    public boolean isElementPresent() {
        try {
            getWebDriwerWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement find() {
        return getWebDriwerWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
