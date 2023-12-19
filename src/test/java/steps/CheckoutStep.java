package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;
import static steps.DriverFactory.driver;

public class CheckoutStep {

    @And("user has random product in the cart")
    public void userHasRandomProductInTheCart() {
        assertTrue(removeItemisDisplayed()&&proceedToCheckoutIsDisplayed());
    }

    private boolean removeItemisDisplayed() {
        WebElement removeItem = driver.findElement(AppiumBy.androidUIAutomator("text(\"Remove Item\")"));
        return removeItem.isDisplayed();
    }
    public boolean proceedToCheckoutIsDisplayed() {
        WebElement proceedToCheckout = driver.findElement(AppiumBy.accessibilityId("Proceed To Checkout button"));
        return proceedToCheckout.isDisplayed();
    }

    @When("user enters {string} in shipping address {string}")
    public void userEntersInShippingAddress(String data, String field) {
        WebElement inputField = driver.findElement(AppiumBy.accessibilityId(field));
        inputField.sendKeys(data);
    }

    @Then("user is navigated to {string} window")
    public void userIsNavigatedToWindow(String name) {
        WebElement windowName = driver.findElement(AppiumBy.androidUIAutomator("textContains(\""+name+"\")"));
        assertTrue(windowName.isDisplayed());
    }

    @Given("user is on {string} window")
    public void userIsOnWindow(String name) {
        WebElement windowName = driver.findElement(AppiumBy.androidUIAutomator("textContains(\""+name+"\")"));
        assertTrue(windowName.isDisplayed());
    }

    @When("user enters {string} in payment method {string}")
    public void userEntersInPaymentMethod(String data, String field) {
        WebElement inputField = driver.findElement(AppiumBy.accessibilityId(field));
        inputField.sendKeys(data);
    }

    @Then("the user is navigated {string} page")
    public void theUserIsNavigatedPage(String name) {
        WebElement chechoutScreen = driver.findElement(AppiumBy.accessibilityId("checkout complete screen"));
        assertTrue(chechoutScreen.isDisplayed());
    }


    @When("user can see {string} in {string}")
    public void userCanSeeIn(String data, String datatype) {
        WebElement addressName = driver.findElement(AppiumBy.xpath("//*[@content-desc='" + datatype + "']" +
                "/*[contains(@text, '" + data + "')]"));
        assertTrue(addressName.isDisplayed());
    }
}
