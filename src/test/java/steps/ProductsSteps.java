package steps;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;
import static Utils.Waiter.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static steps.DriverFactory.driver;

public class ProductsSteps {
    public final String productsName = getRandomItemsName();

    @Given("user is on the {string} page")
    public void theUserIsOnThePage(String pageName) {
        assertTrue(driver.findElement(AppiumBy.androidUIAutomator("text(\""+pageName+"\")")).isDisplayed());
    }

    @When("user scrolls down the page")
    public void userScrollsDownThePage() {
        scroll();
    }
    private void scroll() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int usablePercentage = 80;
        int scrollableHeight = screenHeight * usablePercentage /100;
        int scrollableWidth = screenWidth * usablePercentage /100;

        int startPercentage = 20;
        int speed = 1000;

        int scrollStartX = (int) (scrollableHeight * startPercentage /100.0);
        int scrollStartY = (int) (scrollableWidth * startPercentage /100.0);

        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", scrollStartX, "top", scrollStartY, "width",scrollableWidth , "height", scrollableHeight,
                "direction", "down",
                "percent", 1,
                "speed", speed));
    }

    @Then("user should see a continuous list of products with a visible photo, title, and price displayed")
    public void userShouldSeeAContinuousListOfProducts() {
        List<WebElement> items = driver.findElements(AppiumBy.xpath("//*[@content-desc=\"store item\"]"));
        assertTrue(itemContentFullyDisplayed(items.get(items.size() - 1)));
    }
    public boolean itemContentFullyDisplayed(WebElement item) {
        WebElement itemsPhoto = item.findElement(AppiumBy.xpath(".//android.widget.ImageView"));
        WebElement itemsPrice = item.findElement(AppiumBy.xpath(".//*[@content-desc=\"store item price\"]"));
        WebElement itemsText = item.findElement(AppiumBy.xpath(".//*[@content-desc=\"store item text\"]"));

        return itemsPhoto.isDisplayed() && itemsPrice.isDisplayed() && itemsText.isDisplayed();
    }

@When("user clicks on a random product in the list")
   public void userClicksOnARandomProductInTheList() {
        WebElement randomItem = driver.findElement(AppiumBy.androidUIAutomator("text(\""+productsName+"\")"));
       randomItem.click();
}
    public String getRandomItemsName(){
        Random random = new Random();
        List<WebElement>items =driver.findElements(AppiumBy.xpath("//*[@content-desc=\"store item text\"]"));
        WebElement randomElement = items.get(random.nextInt(items.size()));
        String name = randomElement.getText();
        return name;}

    @Then("user is navigated to detailed products page")
    public void userIsNavigatedToPage() {
        assertTrue(driver.findElement(AppiumBy.xpath("//*[@content-desc=\"product screen\"]")).isDisplayed());
        assertEquals(driver.findElement(AppiumBy.xpath("//*[@content-desc=\"container header\"]//android.widget.TextView")).getText(),productsName);
    }

    @Then("popup appears with a message {string}")
    public void popupAppearsWithAMessage(String message) {
        WebElement popupText = driver.findElement(AppiumBy.className("android.widget.TextView"));
        assertEquals(popupText.getText(), message);
    }

    @Then("popup disappears")
    public void popupDisappears(){
        justWait(   driver, DEFAULT_DURATION);
        assertEquals(driver.findElements(AppiumBy.androidUIAutomator("text(\"Thank you for submitting your review!\")")).size(), 0);
    }

    @When("user clicks on the {string} next to a random product in the list")
    public void userClicksOnTheNextToARandomProductInTheList(String number) {
        WebElement ramdomProduct =driver.findElement(AppiumBy.xpath("//*[@text=\""+productsName+"\"]/../../*[@content-desc=\"review star "+number+"\"]"));
        ramdomProduct.click();
    }
}
