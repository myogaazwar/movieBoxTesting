package com.moviebox.pages;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MoviesPage extends BasePage {
    private final By titleHeaderMoviesPage = By.cssSelector("body > main > div > h1");
    private  final By buttonFavoritePage = By.xpath("/html/body/nav/div/div/a[2]");

    private final By allCardsMovie = By.xpath("/html/body/main/div/div[4]//a");

    private final By inputSearchMovie= By.name("search_movies");
    private final By buttonSearch = By.id("btn_search");

    private final By titleFirstCardMovie = By.xpath("//h3[@x-text=\"movie.Title\"]");
    private final By movieCard = By.xpath("/html/body/main/div/div[4]/a[1]");

    private final By loadingElement = By.cssSelector("body > main > div > div.mt-4.loader");
    private final By messageMoviesNotFound = By.cssSelector("body > main > div > div.mt-4.text-red-500");

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

    public void waitLoadingFinished() {
        waitElementUntilGone(loadingElement);
        delay(3000);
    }

    public void clickSearchMovie() {
        click(buttonSearch);
    }

    public WebElement getTextMessageMovieNotFound() {
        return find(messageMoviesNotFound);
    }

    public WebElement getTitleFirstCardMovie () {
        return find(titleFirstCardMovie);
    }

    public void clickMovie(By locator) {
        click(locator);
    }

    public DetailMoviePage goToDetailMovie() {
        clickMovie(movieCard);
        return new DetailMoviePage();
    }


    public FavoritePage goToFavoritePage() {
        click(buttonFavoritePage);

        return new FavoritePage();
    }

}
