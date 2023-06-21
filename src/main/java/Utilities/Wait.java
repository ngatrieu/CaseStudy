package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    public static void untilElementIsVisible(WebDriver webDriver, WebElement webElement, long timeOutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.visibilityOf(webElement));
    }
}
