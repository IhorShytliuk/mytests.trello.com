package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.trello.ui.core.BrowserFactory.get;
import static com.trello.ui.core.Constants.URL;

public class LoginPage extends BasePage{

    public static final String PATH = "login";

    private Elem emailFld = new Elem(By.xpath("//input[@name='user']"), "Login Field");
    private Elem pswdFld = new Elem(By.xpath("//input[@name='password']"), "Pswd Field");
    private Elem loginBtn = new Elem(By.xpath("//input[@id='login']"), "Login Btn");

    public void login(String email, String pswd) {
        open();
        emailFld.typeText(email);
        pswdFld.typeText(pswd);
        loginBtn.click();
//        isElementPresent(homeBy);
    }

    public void open() {
        get(URL + PATH);
        Assert.assertTrue(isOpened(), "Page 'Login' " + PATH + " is not Opened");
    }

    public boolean isOpened() {
        return loginBtn.isElementPresent();
    }

    public boolean isLogined() {
        return new Elem(By.xpath("//*[@class='content-all-boards']")).isElementPresent();
    }
}
