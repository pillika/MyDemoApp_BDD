package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static steps.DriverFactory.driver;

public class DetailedProductStep {
    @Then("the page should display a title, description, photo, price, star rating, color, count, and an \"Add To Cart\" button")
    public void thePageShouldDisplayATitleDescriptionPhotoPriceStarRatingColorCountAndAnButton() {
       assertTrue(detailedProductsContentIsDisplayed());
    }
    public boolean detailedProductsContentIsDisplayed() {
        WebElement title= driver.findElement(AppiumBy.accessibilityId("container header"));
        WebElement description = driver.findElement(AppiumBy.accessibilityId("product description"));
        WebElement photo = driver.findElement(AppiumBy.xpath("//*[@content-desc=\"container header\"]/following-sibling::android.widget.ImageView[1]"));
        WebElement price = driver.findElement(AppiumBy.xpath("//*[@content-desc=\"product price\"]"));
        WebElement count =driver.findElement(AppiumBy.accessibilityId("counter amount"));
        WebElement addtoCart = driver.findElement(AppiumBy.accessibilityId("Add To Cart button"));
        return starRatingIsDisplayed() && colorIsDisplayed() && title.isDisplayed() && description.isDisplayed()
                && photo.isDisplayed() && price.isDisplayed() && count.isDisplayed() && addtoCart.isDisplayed();
    }
    public boolean starRatingIsDisplayed() {
        WebElement oneStar = driver.findElement(AppiumBy.accessibilityId("review star 1"));
        WebElement twoStars = driver.findElement(AppiumBy.accessibilityId("review star 2"));
        WebElement threeStars = driver.findElement(AppiumBy.accessibilityId("review star 3"));
        WebElement forStars =driver.findElement(AppiumBy.accessibilityId("review star 4"));
        WebElement fiveStars = driver.findElement(AppiumBy.accessibilityId("review star 5"));
        return oneStar.isDisplayed() && twoStars.isDisplayed() && threeStars.isDisplayed() && forStars.isDisplayed()
                && fiveStars.isDisplayed();
    }
    public boolean colorIsDisplayed() {
        List<WebElement> colorchoices = driver.findElements(AppiumBy.xpath("//*[@content-desc[contains(., 'circle')]]"));
        if (!colorchoices.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @When("the user selects {string} for the product")
    public void theUserSelectsACountForTheProduct(String count) {
        changeAmount(count);
    }
    public void changeAmount(String count) {
        for (int i = 1; i < Integer.valueOf(count); i++) {
            WebElement plus = driver.findElement(AppiumBy.accessibilityId("counter plus button"));
            plus.click();
        }
    }

    @And("selects random color")
    public void selectsRandomColor() {
        clickRandomColor();
    }
    public void clickRandomColor() {
        List<WebElement> colorchoices = driver.findElements(AppiumBy.xpath("//*[@content-desc[contains(., 'circle')]]"));
        Random random = new Random();
        WebElement randomColor = colorchoices.get(random.nextInt(colorchoices.size()));
        randomColor.click();
    }

    @Then("the product is added to the cart,where the total {string} of items in the cart is displayed")
    public void theProductIsAddedToTheCartWhereTheTotalCountOfItemsInTheCartIsDisplayed(String count) {
       assertEquals(getCartItemsCount(),count);
    }
    public String getCartItemsCount() {
        WebElement cartCount = driver.findElement(AppiumBy.xpath("//*[@content-desc=\"cart badge\"]/android.widget.TextView"));
        return cartCount.getText();
    }

    @And("clicks Cart icon")
    public void clicksCartIcon() {
        WebElement cart = driver.findElement(AppiumBy.accessibilityId("cart badge"));
        cart.click();
    }
}
