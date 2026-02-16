package com.moviebox.base.login;

import com.moviebox.base.BaseTest;
import com.moviebox.pages.MoviesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)

    public void testConfirmOnLoginPageIndonesia() {
        String textDescriptionLoginPage =  loginPage.readingDescriptioPage();
        String expectedText ="Login untuk melihat daftar film";

        Assert.assertEquals(textDescriptionLoginPage, expectedText );
        Assert.assertNotEquals(textDescriptionLoginPage, "Login to see the list of movies");
    }

    @Test(priority = 2)
    public void testChangeLanguageToEnglish() {
       String textDescriptionLoginPageIndonesia = loginPage.readingDescriptioPage();
        String expectedTextIndonesia ="Login untuk melihat daftar film";

        Assert.assertEquals(textDescriptionLoginPageIndonesia, expectedTextIndonesia);

        loginPage.changeLanguage();

        String textDescriptionLoginPageEnglish = loginPage.readingDescriptioPage();
        String expectedTextEnglish = "Login to see the list of movies";
        Assert.assertEquals(textDescriptionLoginPageEnglish, expectedTextEnglish );

        loginPage.changeLanguage();
    }


    @Test(priority = 3)
    public void testLoginFailedWithEmptyUsernameAndPassword () {
        loginPage.sendInputLogin("", "");
        loginPage.clickButtonLogin();

        String textErrorMessageUsername = loginPage.readingErrorMessageFieldUsername();
        String expectedTextErrorMessageUsername = "Kolom username wajib diisi.";

        String textErrorMessagePassword = loginPage.readingErrorMessageFieldPassword();
        String expectedTextErrorMesssagePassword = "Kolom password wajib diisi.";

        Assert.assertEquals(textErrorMessageUsername, expectedTextErrorMessageUsername);
        Assert.assertEquals(textErrorMessagePassword, expectedTextErrorMesssagePassword);
    }

    @Test(priority = 4)
    public void testLoginFailedBecausePasswordWrong() {
        loginPage.sendInputLogin("yoga", "passwordsalah");
        loginPage.clickButtonLogin();

        String textErrorMessage = loginPage.readingErrorMessageFieldUsername();
        String expectedTextErrorMessage = "Nama pengguna atau kata sandi salah.";

        Assert.assertEquals(textErrorMessage, expectedTextErrorMessage);
    }

    @Test(priority = 5)
    public void testSuccessLogin() {
       MoviesPage moviesPage = loginPage.logIntoApplication("yoga", "12345");
       String titleHeaderMoviesPage = moviesPage.isTitleHeaderMoviesPageDisplayed();

       String expectedTitleHeaderMoviesPage = "Daftar Film";
       Assert.assertEquals(titleHeaderMoviesPage, expectedTitleHeaderMoviesPage);
    }

}
