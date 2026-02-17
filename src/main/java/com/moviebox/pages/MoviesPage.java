package com.moviebox.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MoviesPage extends BasePage {
    private final By titleHeaderMoviesPage = By.cssSelector("body > main > div > h1");
    private final By allCardsMovie = By.xpath("/html/body/main/div/div[4]//a");


    private final By inputSearchMovie= By.name("search_movies");
    private final By buttonSearch = By.id("btn_search");

    private final By titleFirstCardMovie = By.xpath("//h3[contains(normalize-space(), 'Beatles')]");
    private final By movieCard = By.xpath("/html/body/main/div/div[4]/a[1]");

    public WebElement isTitleHeaderMoviesPageDisplayed() {
        return find(titleHeaderMoviesPage);
    }

    public String isSearchCurrentTextDisplayed() {
        return find(inputSearchMovie).getAttribute("value");
    }

    public List<WebElement> getAllMoviesCards() {
        return findAll(allCardsMovie);
    }

    public void searchMovie(String text) {
        set(inputSearchMovie, text);
    }

    public void clickSearchMovie() {
        click(buttonSearch);
    }

    public WebElement getTitleFirstCardMovie () {
        return find(titleFirstCardMovie);
    }

    public void clickMovie(By locator) {
        click(locator);
    }

    public DetailMovie goToDetailMovie() {
        clickMovie(movieCard);
        return new DetailMovie();
    }
}
