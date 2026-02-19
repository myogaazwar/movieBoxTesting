package com.moviebox.base.movies;

import com.moviebox.base.BaseTest;
import com.moviebox.pages.FavoritePage;
import com.moviebox.pages.MoviesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoriteMovieTest extends BaseTest {


    @Test
    public void MOVIES_SCN_005_TC_001_SuccessShowFavoriteMovies() {
         FavoritePage favoritePage = loginPage.logIntoApplication("yoga", "12345").goToFavoritePage();

        int expectedMinimumTotalMovieFavorite = 1;
        int totalMovieFavorite = favoritePage.getAllMoviesFavoriteCards().size();

        Assert.assertTrue(totalMovieFavorite > expectedMinimumTotalMovieFavorite, "Total favorite movie card kurang dari " + expectedMinimumTotalMovieFavorite);
    }

    @Test
    public void MOVIES_SCN_006_TC_001_DisplayMessageWhenFavoriteMoviesEmpty() {
        FavoritePage favoritePage = loginPage.logIntoApplication("yoga", "12345").goToFavoritePage();

       favoritePage.getTextMessageFavoriteMovieEmpty().isDisplayed();


    }
}
