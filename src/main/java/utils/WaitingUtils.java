package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static manager.DriverManager.getDriver;

public class WaitingUtils {

    private static final long DEFAULT_TIMEOUT = 60;

    public static void waitForPageLoadComplete() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static List<WebElement> waitVisibilityOfElements(WebDriver driver, List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        return elements;
    }

    public static void waitForAjaxToComplete() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }
}
