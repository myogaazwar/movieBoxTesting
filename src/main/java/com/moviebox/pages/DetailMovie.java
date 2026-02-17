package com.moviebox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DetailMovie extends LoginPage{
    private final By titleMovie = By.cssSelector("body > main > div > div > div > h1");
    private final By yearMovie = By.cssSelector("body > main > div > div > div > div.flex.flex-wrap.items-center.gap-3.mt-4 > p:nth-child(1)");


    public WebElement isTitleMovieDisplayed() {
        return find(titleMovie);
    }

    public WebElement isYearDisplayed() {
        return find(yearMovie);
    }
}
