package com.moviebox.base.auth;

import ExtentManager.ExtentTestListener;
import com.moviebox.base.BaseTest;
import com.moviebox.pages.MoviesPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentTestListener.class)
public class AuthTest extends BaseTest {

    @Test
    public void AUTH_SCN_001_TC_001_CannotGoToTheMoviesPageWithoutLogin() {
            redirectTO("http://127.0.0.1:8000/id/movies");
            String textDescriptionLoginPage = loginPage.readingDescriptioPage();
            Assert.assertEquals(textDescriptionLoginPage, "Login untuk melihat daftar film", "Text tidak sesuai, anda tidak berada di login page");
    }

    @Test
    public void AUTH_SCN_001_TC_002_CannotGoToDetailMoviePageWithoutLogin() {
        redirectTO("http://127.0.0.1:8000/id/movies/tt0409591");
        String textDescriptionLoginPage = loginPage.readingDescriptioPage();
        Assert.assertEquals(textDescriptionLoginPage, "Login untuk melihat daftar film", "Text tidak sesuai, anda tidak berada di login page");
    }

    @Test
    public void AUTH_SCN_001_TC_002_CannotGoToFavoriteMoviesPageWithoutLogin() {
        redirectTO("http://127.0.0.1:8000/id/movies/favorites");
        String textDescriptionLoginPage = loginPage.readingDescriptioPage();
        Assert.assertEquals(textDescriptionLoginPage, "Login untuk melihat daftar film", "Text tidak sesuai, anda tidak berada di login page");
    }


    @Test
    public void AUTH_SCN_002_TC_001_ConfirmDefaultLoginPageIsIndonesia() {
        String textDescriptionLoginPage =  loginPage.readingDescriptioPage();
        String expectedText ="Login untuk melihat daftar film";

        Assert.assertEquals(textDescriptionLoginPage, expectedText );
        Assert.assertNotEquals(textDescriptionLoginPage, "Login to see the list of movies");
    }


    @Test
    public void AUTH_SCN_002_TC_002_SuccessChangeLanguageFromIndonesiaToEnglish() {
        String textDescriptionLoginPageIndonesia = loginPage.readingDescriptioPage();
        String expectedTextIndonesia ="Login untuk melihat daftar film";

        Assert.assertEquals(textDescriptionLoginPageIndonesia, expectedTextIndonesia);

        loginPage.changeLanguage();

        String textDescriptionLoginPageEnglish = loginPage.readingDescriptioPage();
        String expectedTextEnglish = "Login to see the list of movies";
        Assert.assertEquals(textDescriptionLoginPageEnglish, expectedTextEnglish );

        loginPage.changeLanguage();
    }

    @Test
    public void AUTH_SCN_003_TC_001_LoginFailedWithEmptyUsernameAndPassword () {
        loginPage.sendInputLogin("", "");
        loginPage.clickButtonLogin();

        String textErrorMessageUsername = loginPage.readingErrorMessageFieldUsername().getText();
        String expectedTextErrorMessageUsername = "Kolom username wajib diisi.";

        String textErrorMessagePassword = loginPage.readingErrorMessageFieldPassword().getText();
        String expectedTextErrorMesssagePassword = "Kolom password wajib diisi.";

        Assert.assertEquals(textErrorMessageUsername, expectedTextErrorMessageUsername);
        Assert.assertEquals(textErrorMessagePassword, expectedTextErrorMesssagePassword);
    }


    @Test
    public void AUTH_SCN_003_TC_002_LoginFailedWithEmptyUsername(){
        loginPage.sendInputLogin("", "12345");
        loginPage.clickButtonLogin();

        String textErrorMessageUsername = loginPage.readingErrorMessageFieldUsername().getText();
        String expectedTextErrorMessageUsername = "Kolom username wajib diisi.";

        Assert.assertEquals(textErrorMessageUsername, expectedTextErrorMessageUsername);
    }


    @Test
    public void AUTH_SCN_003_TC_003_LoginFailedBecausePasswordWrong() {
        loginPage.sendInputLogin("yoga", "passwordsalah");
        loginPage.clickButtonLogin();

        String textErrorMessage = loginPage.readingErrorMessageFieldUsername().getText();
        String expectedTextErrorMessage = "Nama pengguna atau kata sandi salah.";

        Assert.assertEquals(textErrorMessage, expectedTextErrorMessage);
    }


    @Test
    public void AUTH_SCN_004_TC_001_SuccessLogin() {
        MoviesPage moviesPage = loginPage.logIntoApplication("yoga", "12345");
        String titleHeaderMoviesPage = moviesPage.isTitleHeaderMoviesPageDisplayed().getText();
        boolean isTitleHeaderMovieDisplay = moviesPage.isTitleHeaderMoviesPageDisplayed().isDisplayed();

        String expectedTitleHeaderMoviesPage = "Daftar Film";
        Assert.assertEquals(titleHeaderMoviesPage, expectedTitleHeaderMoviesPage);

        Assert.assertTrue(isTitleHeaderMovieDisplay);
    }

    @Test
    public void AUTH_SCN_005_TC_001_SuccessLogout() {
       loginPage.logIntoApplication("yoga", "12345");
       loginPage.logoutApplication();
    }



}
