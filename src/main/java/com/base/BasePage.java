package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    public void setDriver(WebDriver driver, Wait<WebDriver> wait) {
        BasePage.driver = driver;
        BasePage.wait = wait;
    }

    protected WebElement find(By locator) {
        return BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement findWithoutWait(By locator) {
        return BasePage.driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return BasePage.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void waitElementUntilGone(By locator) {
        BasePage.wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
