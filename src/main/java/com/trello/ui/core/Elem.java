package com.trello.ui.core;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.trello.ui.core.BrowserFactory.getWebDriverWait;

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
        isElementPresent();
        WebElement element = find();
        element.clear();
        element.sendKeys(text);
    }

    public String getText() {
        isElementPresent();
        WebElement element = find();
        return element.getText();
    }

    public String getAttributeValue(String attribuute) {
        isElementPresent();
        WebElement element = find();
        return element.getAttribute(attribuute);
    }

    public void click() {
        isElementPresent();
        find().click();
    }

    public boolean isElementPresent() {
        try {
            getWebDriverWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement find() {
        return getWebDriverWait(10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
