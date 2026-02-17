package com.moviebox.base.movies;

import ExtentManager.ExtentTestListener;
import com.moviebox.base.BaseTest;
import com.moviebox.pages.DetailMovie;
import com.moviebox.pages.MoviesPage;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ExtentTestListener.class)
public class MoviesTest extends BaseTest {

//    @BeforeMethod
//    public void setup() {
//        loginPage.logIntoApplication("yoga", "12345");
//    }

    @Test
    public void testSearchCurrentIsDisplayedSuccess() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");

        String expectedTextSearchCurrent = "naruto";
        String textSearchCurrent = moviespage.isSearchCurrentTextDisplayed();
        Assert.assertEquals(textSearchCurrent, expectedTextSearchCurrent);
    }

    @Test
    public void testGetAllMovieCardsSuccess() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");

        int expectedMinimumTotalMovieCards = 2;
        int totalMovieCards = moviespage.getAllMoviesCards().size();

        Assert.assertTrue(totalMovieCards > expectedMinimumTotalMovieCards, "Total movie card kurang dari " + expectedMinimumTotalMovieCards);
    }


    @Test
    public void testSearchMovieSuccess() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");

        String expectedSearchMovie = "The Beatles";
        moviespage.searchMovie(expectedSearchMovie);
        moviespage.clickSearchMovie();


        String firstTitleCardMovie = moviespage.getTitleFirstCardMovie().getText();

        System.out.println(firstTitleCardMovie);
        Assert.assertTrue(firstTitleCardMovie.contains("Beatles"), "Tidak sesuai");

    }


    @Test
    public void testSuccessGoToDetailMovie() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");
        DetailMovie detailMovie = moviespage.goToDetailMovie();


        String textTitleDetailMovie = detailMovie.isTitleMovieDisplayed().getText();
        String textYearDetailMovie = detailMovie.isYearDisplayed().getText();

        Assert.assertEquals(textTitleDetailMovie, "Naruto: Shippuden", "Title tidak sama!");
        Assert.assertTrue(textYearDetailMovie.contains("2007"), "Tahun rilis tidak sesuai");
        Assert.assertTrue(textYearDetailMovie.contains("2017"), "Tahun last movie tidak sesuai ");

    }

}
