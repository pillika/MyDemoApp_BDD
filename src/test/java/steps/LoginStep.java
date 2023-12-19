package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import static Utils.Waiter.DEFAULT_DURATION;
import static Utils.Waiter.waitForElementVisibility;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static steps.DriverFactory.driver;


public class LoginStep {

@Given("User can see username and password input fields")
public void user_can_see_username_and_password_input_fields() {
    WebElement usernameInput = driver.findElement(AppiumBy.accessibilityId("Username input field"));
    WebElement passwordInput = driver.findElement(AppiumBy.accessibilityId("Password input field"));
    assertTrue(usernameInput.isDisplayed());
    assertTrue(passwordInput.isDisplayed());
        }
@When("User enters {string}")
public void user_enters_valid_username(String username) {
    WebElement usernameInput = driver.findElement(AppiumBy.accessibilityId("Username input field"));
    usernameInput.sendKeys(username);
        }
@And("enters {string}")
public void enters_valid_password(String password) {
    WebElement passwordInput = driver.findElement(AppiumBy.accessibilityId("Password input field"));
    passwordInput.sendKeys(password);
        }
@And("clicks {string} button")
public void clicks_button(String text) {
    WebElement button = driver.findElement(AppiumBy.accessibilityId(text+" button"));
    button.click();
        }
    @Then("user can successfully log in")
public void user_can_successfully_log_in() {
    WebElement productsLogo = driver.findElement(AppiumBy.androidUIAutomator("text(\"Products\")"));
    assertTrue(productsLogo.isDisplayed());
        }
    @Then("user gets error {string}")
    public void userGets(String message) {
        WebElement error = driver.findElement(AppiumBy.androidUIAutomator("textContains(\""+message+"\")"));
        String errorMessage = error.getText();
        waitForElementVisibility(driver, error, DEFAULT_DURATION);
        assertEquals(errorMessage,message);}

    @Given("user clicks menu button")
    public void userClicksMenuButton() {
        WebElement sideMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
        sideMenu.click();
    }

    @And("clicks {string}")
    public void clicks(String buttonText) {
        WebElement button = driver.findElement(AppiumBy.androidUIAutomator("text(\""+buttonText+"\")"));
        button.click();
    }
}