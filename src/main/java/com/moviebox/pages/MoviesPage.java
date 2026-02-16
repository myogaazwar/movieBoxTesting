package com.moviebox.pages;

import org.openqa.selenium.By;

public class MoviesPage extends LoginPage{
    private final By titleHeaderMoviesPage = By.cssSelector("body > main > div > h1");


    public String isTitleHeaderMoviesPageDisplayed() {
        return find(titleHeaderMoviesPage).getText();
    }
}
