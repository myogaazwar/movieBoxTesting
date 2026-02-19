package com.moviebox.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FavoritePage extends MoviesPage {

    private final By allCardsFavoriteMovie = By.xpath("/html/body/main/div/div/a");
    private final By textFavoritesMovieEmpty = By.cssSelector("body > main > div > div");

    private final By firstCardsFavoriteMovie = By.xpath("/html/body/main/div/div/a[1]");

    public List<WebElement> getAllMoviesFavoriteCards() {
        return findAll(allCardsFavoriteMovie);
    }

    public WebElement getTextMessageFavoriteMovieEmpty() {
        return find(textFavoritesMovieEmpty);
    }

    public DetailMoviePage clickFirstCardFavoriteMovie() {
        click(firstCardsFavoriteMovie);

        return new DetailMoviePage();
    }



}
