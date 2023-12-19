package Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    public static final Duration DEFAULT_DURATION = Duration.ofSeconds(2);

    public static void waitForElementVisibility(WebDriver driver, WebElement element, Duration duration) {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void justWait(WebDriver driver, Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration);
    }
}

