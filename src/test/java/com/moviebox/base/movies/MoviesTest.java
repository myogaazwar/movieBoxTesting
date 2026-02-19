package com.moviebox.base.movies;

import ExtentManager.ExtentTestListener;
import com.moviebox.base.BaseTest;
import com.moviebox.pages.DetailMoviePage;
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
    public void MOVIES_SCN_001_TC_001_SearchCurrentMoviesIsDisplayedSuccess() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");

        String expectedTextSearchCurrent = "naruto";
        String textSearchCurrent = moviespage.isSearchCurrentTextDisplayed();
        Assert.assertEquals(textSearchCurrent, expectedTextSearchCurrent);
    }

    @Test
    public void MOVIES_SCN_001_TC_002_SearchMovieSuccess() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");

        moviespage.waitLoadingFinished();

        String expectedSearchMovie = "Agak Laen";
        moviespage.searchMovie(expectedSearchMovie);
        moviespage.clickSearchMovie();
        moviespage.waitLoadingFinished();


        String firstTitleCardMovie = moviespage.getTitleFirstCardMovie().getText();
        Assert.assertTrue(firstTitleCardMovie.contains("Agak Laen"), "Tidak sesuai");

    }


    @Test
    public void MOVIES_SCN_002_TC_002_SearchMovieIsNotFound() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");
        moviespage.waitLoadingFinished();

        String expectedSearchMovie = "SSSSSSSSSSSS";
        moviespage.searchMovie(expectedSearchMovie);
        moviespage.clickSearchMovie();

        moviespage.waitLoadingFinished();

        String textMessageMoviesNotFound = moviespage.getTextMessageMovieNotFound().getText();

        Assert.assertEquals(textMessageMoviesNotFound,  "Maaf data film yang kamu cari tidak ada");
    }

    @Test
    public void MOVIES_SCN_003_TC_001_SuccessGoToDetailMovie() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");
        moviespage.waitLoadingFinished();

        String expectedSearchMovie = "Agak Laen";
        moviespage.searchMovie(expectedSearchMovie);
        moviespage.clickSearchMovie();
        moviespage.waitLoadingFinished();

        DetailMoviePage detailMovie = moviespage.goToDetailMovie();

        String textTitleDetailMovie = detailMovie.isTitleMovieDisplayed().getText();
        String textYearDetailMovie = detailMovie.isYearDisplayed().getText();

        Assert.assertEquals(textTitleDetailMovie, expectedSearchMovie, "Title tidak sama!");
        Assert.assertTrue(textYearDetailMovie.contains("2024"), "Tahun rilis tidak sesuai");

    }



    @Test
    public void testGetAllMovieCardsSuccess() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");

        int expectedMinimumTotalMovieCards = 2;
        int totalMovieCards = moviespage.getAllMoviesCards().size();

        Assert.assertTrue(totalMovieCards > expectedMinimumTotalMovieCards, "Total movie card kurang dari " + expectedMinimumTotalMovieCards);
    }




}
