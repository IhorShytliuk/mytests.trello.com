package com.trello.ui.pages;

import com.trello.ui.core.Elem;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import static com.trello.ui.core.BrowserFactory.get;
import static com.trello.ui.core.Constants.URL;

public class LoginPage {

    public static final String PATH = "login";

    private Elem emailFld = new Elem(By.xpath("//input[@name='user']"), "Login Field");
    private Elem pswdFld = new Elem(By.xpath("//input[@name='password']"), "Pswd Field");
    private Elem loginBtn = new Elem(By.xpath("//input[@id='login']"), "Login Btn");

    public void login(String email, String pswd) {
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

//    public boolean isLoggedOut() {
//        return driver.getCurrentUrl().contains("logged-out");
//    }
}
