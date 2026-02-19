package com.moviebox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DetailMoviePage extends LoginPage{
    private final By titleMovie = By.cssSelector("body > main > div > div > div > h1");
    private final By yearMovie = By.cssSelector("body > main > div > div > div > div.flex.flex-wrap.items-center.gap-3.mt-4 > p:nth-child(1)");

    private final By buttonAddToFavorite = By.id("btn_addFavorite");
    private final By buttonRemoveFromFavorite = By.id("btn_removeFavorite");

    public WebElement isTitleMovieDisplayed() {
        return find(titleMovie);
    }
    public WebElement isYearDisplayed() {
        return find(yearMovie);
    }

    public WebElement clickButtonAddToFavorite() {
        click(buttonAddToFavorite);

        return find(buttonRemoveFromFavorite);
    }

    public WebElement clickButtonRemoveFromFavorite() {
        click(buttonRemoveFromFavorite);

        return find(buttonAddToFavorite);
    }
}
