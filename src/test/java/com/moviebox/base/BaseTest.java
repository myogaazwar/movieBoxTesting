package com.moviebox.base;

import com.base.BasePage;
import com.moviebox.pages.LoginPage;
import com.moviebox.pages.MoviesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static utilities.Utility.setUtilityDriver;

public class BaseTest {
    private WebDriver driver;
    private Wait<WebDriver> wait;


    protected BasePage basePage;
    protected MoviesPage moviesPage;

    protected LoginPage loginPage;

    private String MOVIEBOX_URL = "http://127.0.0.1:8000/";

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.get(MOVIEBOX_URL);
    }

    @BeforeMethod
    public void loadApplication() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        basePage = new BasePage();
        basePage.setDriver(driver, wait);

        setUtilityDriver();

        loginPage = new LoginPage();
        moviesPage = new MoviesPage();


    }

    @AfterClass
    public void tearDown() {
        BasePage.delay(6000);
        driver.quit();
    }

}
