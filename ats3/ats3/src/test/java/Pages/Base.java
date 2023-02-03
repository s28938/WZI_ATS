package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    public WebDriver browser;
    public WebDriverWait wait;

    public Base(WebDriver browserDriver) {
        browser = browserDriver;
        wait = new WebDriverWait(browser, Duration.ofMinutes(2));
    }

    protected void waitForPageTitle (String pageTitle) {
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

    protected void waitUntilVisibility (By item) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(item));
    }

    protected WebElement findElement (By item) {
        return browser.findElement(item);
    }




}
