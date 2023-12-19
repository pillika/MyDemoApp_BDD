package steps;

import com.google.common.collect.Ordering;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.testng.Assert.assertTrue;
import static steps.DriverFactory.driver;

public class SortSteps {
    @Given("User is on {string} Page")
    public void userIsOnPage(String text) {
        assertTrue(driver.findElement(AppiumBy.androidUIAutomator("text(\"" + text + "\")")).isDisplayed());
    }

    @Then("products are listed {string}")
    public void productsAreSortedCorrectly(String orderType) { //nameAsc
        List<String> itemsTexts = getItemsTexts();

        if(orderType.equals("ascending")){
             assertTrue(Ordering.<String> natural().isOrdered(itemsTexts));
        }
        else{
            assertTrue(Ordering.<String> natural().reverse().isOrdered(itemsTexts));
        }
    }

    private List<String> getItemsTexts() {
        List<WebElement> items = driver.findElements(AppiumBy.xpath("//*[@content-desc=\"store item text\"]"));
        List<String> itemsTexts = items.stream()
                .map(item -> item.getText().toLowerCase())
                .toList();

        return itemsTexts;
    }

    @And("chooses the sorting by {string} and {string}")
    public void choosesTheSortingByAnd(String field, String order) {
        WebElement sort = driver.findElement(AppiumBy.accessibilityId(field+order));
        sort.click();
    }

    @Then("products are sorted by {string} and {string}")
    public void productsAreSortedByAnd(String field, String order) {
        if(field.equals("name")){
            List<String> itemsTexts = getItemsTexts();

            if(order.equals("Asc")){
                assertTrue(Ordering.<String> natural().isOrdered(itemsTexts));
            }
            else{
                assertTrue(Ordering.<String> natural().reverse().isOrdered(itemsTexts));
            }

        }else {
            List<Double> itemsPrice = getItemsPrices();

            if(order.equals("Asc")){
                assertTrue(Ordering.<Double> natural().isOrdered(itemsPrice));
            }
            else{
                assertTrue(Ordering.<Double> natural().reverse().isOrdered(itemsPrice));
            }
        }
    }

    private List<Double> getItemsPrices() {
        List<WebElement> priceElements = driver.findElements(AppiumBy.xpath("//*[@content-desc=\"store item price\"]"));
        List<Double> prices = priceElements.stream()
                .map(item -> item.getText().replaceAll("[^0-9.]", ""))
                .map(priceText -> Double.parseDouble(priceText))
                .toList();
        return prices;
    }
    }


