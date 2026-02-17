package com.moviebox.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final By descriptionLoginPage = By.cssSelector("body > main > section > div > div.text-center > h2");
    private final By inputUsername = By.name("username");
    private final By inputPassword = By.name("password");
    private final By buttonCurrentSwitchLanguage = By.cssSelector("body > div > button");
    private final By buttonChoosenSwitchLanguage = By.cssSelector("body > div > div > a");
    private final By buttonLogin = By.cssSelector("body > main > section > div > form > button");
    private final By messageErrorUsername = By.xpath("//input[@name='username']/following-sibling::small");
    private final By messageErrorPassword = By.xpath("//input[@name='password']/following-sibling::small");


    public String readingDescriptioPage () {
        return find(descriptionLoginPage).getText();
    }

    public void changeLanguage() {
        find(buttonCurrentSwitchLanguage).click();
        find(buttonChoosenSwitchLanguage).click();
    }

    public void sendInputLogin(String username, String password) {
            set(inputUsername, username);
            set(inputPassword, password);
    }

    public void clickButtonLogin() {
        click(buttonLogin);
    }

    public String readingErrorMessageFieldUsername() {
        return find(messageErrorUsername).getText();
    }

    public String readingErrorMessageFieldPassword () {
        return find(messageErrorPassword).getText();
    }

    public MoviesPage logIntoApplication (String username, String password) {
        sendInputLogin(username, password);
         clickButtonLogin();
        return new MoviesPage();

    }


}
