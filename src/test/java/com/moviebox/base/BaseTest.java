package com.moviebox.base;

import com.base.BasePage;
import com.moviebox.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private Wait<WebDriver> wait;
    protected BasePage basePage;

    protected LoginPage loginPage;

    private String MOVIEBOX_URL = "http://127.0.0.1:8000/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MOVIEBOX_URL);
    }

    @BeforeMethod
    public void loadApplication() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        basePage = new BasePage();
        basePage.setDriver(driver, wait);
        loginPage = new LoginPage();


    }

    @AfterClass
    public void tearDown() {
        BasePage.delay(3000);
        driver.quit();
    }

}
