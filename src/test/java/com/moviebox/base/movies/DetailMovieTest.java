package com.moviebox.base.movies;

import com.moviebox.base.BaseTest;
import com.moviebox.pages.DetailMoviePage;
import com.moviebox.pages.FavoritePage;
import com.moviebox.pages.MoviesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DetailMovieTest extends BaseTest {

    @Test
    public void SuccessAddMovieToFavorite() {
        MoviesPage moviespage = loginPage.logIntoApplication("yoga", "12345");
        moviespage.waitLoadingFinished();

        String expectedSearchMovie = "Agak Laen";
        moviespage.searchMovie(expectedSearchMovie);
        moviespage.clickSearchMovie();
        moviespage.waitLoadingFinished();

        DetailMoviePage detailMovie = moviespage.goToDetailMovie();

       String textButtonNow =  detailMovie.clickButtonAddToFavorite().getText();
        Assert.assertEquals(textButtonNow, "Hapus dari Favorit", "Kalimat tidak sesuai");

    }


@Test
    public void SuccessRemoveMovieFromFavorite() {
        FavoritePage favoritePage = loginPage.logIntoApplication("yoga", "12345").goToFavoritePage();
       DetailMoviePage detailMoviePage = favoritePage.clickFirstCardFavoriteMovie();

       String textButtonNow = detailMoviePage.clickButtonRemoveFromFavorite().getText();
    Assert.assertEquals(textButtonNow, "Tambah ke Favorit", "Kalimat tidak sesuai");



}
}
